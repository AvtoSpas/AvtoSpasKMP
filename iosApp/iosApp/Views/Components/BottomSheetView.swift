//
//  BottomSheetView.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 13.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

fileprivate enum Constants {
    static let radius: CGFloat = 30
    static let indicatorHeight: CGFloat = 6
    static let indicatorWidth: CGFloat = 60
    static let snapRatio: CGFloat = 0.25
    static let minHeightRatio: CGFloat = 0.51
}

struct BottomSheetView<Content: View>: View {
    let maxHeight: CGFloat
    let minHeight: CGFloat
    @Binding var isProfileMode: Bool
    @Binding var isOrderingCar: Bool
    let content: () -> Content

    @GestureState private var translation: CGFloat = 0
    @State private var currentOffset: CGFloat = 0

    private var indicator: some View {
        RoundedRectangle(cornerRadius: Constants.radius)
            .fill(Color.secondary)
            .frame(width: Constants.indicatorWidth, height: Constants.indicatorHeight)
    }

    init(
        maxHeight: CGFloat,
        isProfileMode: Binding<Bool>,
        isOrderingCar: Binding<Bool>,
        @ViewBuilder content: @escaping () -> Content
    ) {
        self.maxHeight = maxHeight
        self.minHeight = maxHeight * Constants.minHeightRatio
        self._isProfileMode = isProfileMode
        self._isOrderingCar = isOrderingCar
        self.content = content
    }

    var body: some View {
        VStack(spacing: 0) {
            indicator.padding()

            ZStack(alignment: .top) {
                if isOrderingCar {
                    OrderCarView()
                } else if isProfileMode {
                    ProfileMenuView()
                } else {
                    content()
                }
            }
            .frame(maxHeight: .infinity)
            .clipped()
            .animation(.easeInOut(duration: 0.3), value: isProfileMode)
        }
        .background(Color.white)
        .cornerRadius(Constants.radius)
        .offset(y: max(currentOffset + translation, 0))
        .gesture(
            DragGesture()
                .updating($translation) { value, state, _ in
                    state = value.translation.height
                }
                .onEnded { value in
                    let snapDistance = maxHeight * Constants.snapRatio
                    withAnimation(.easeInOut) {
                        if value.translation.height < -snapDistance {
                            isProfileMode = true
                            isOrderingCar = false
                        } else if value.translation.height > snapDistance {
                            isProfileMode = false
                            isOrderingCar = false
                        }
                        currentOffset = (isProfileMode || isOrderingCar) ? 0 : maxHeight - minHeight
                    }
                }
        )
        .onChange(of: isProfileMode) { newValue in
            withAnimation(.easeInOut) {
                if !isOrderingCar {
                    currentOffset = newValue ? 0 : maxHeight - minHeight
                }
            }
        }
        .onChange(of: isOrderingCar) { newValue in
            withAnimation(.easeInOut) {
                currentOffset = newValue ? 0 : maxHeight - minHeight
            }
        }
        .onAppear {
            DispatchQueue.main.async {
                currentOffset = maxHeight - minHeight
            }
        }
    }
}
