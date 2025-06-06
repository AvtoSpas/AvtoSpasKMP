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
        @ViewBuilder content: @escaping () -> Content
    ) {
        self.maxHeight = maxHeight
        self.minHeight = maxHeight * Constants.minHeightRatio
        self._isProfileMode = isProfileMode
        self.content = content
        
        print("maxHeight init: \(maxHeight)")
        print("minHeight init: \(minHeight)")
        print("initialOffset init: \(maxHeight - minHeight)")
    }
    
    var body: some View {
        VStack(spacing: 0) {
            indicator.padding()
            
            ZStack(alignment: .top) {
                MainOrderView(carViewModel: CarsViewModel())
                    .opacity(isProfileMode ? 0 : 1)
                    .frame(maxHeight: .infinity, alignment: .top)
                
                ProfileMenuView()
                    .opacity(isProfileMode ? 1 : 0)
                    .frame(maxHeight: .infinity, alignment: .top)
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
                    
                    print("maxHeight on updating: \(maxHeight)")
                        print("minHeight on updating: \(minHeight)")
                        print("initialOffset on updating: \(maxHeight - minHeight)")
                }
                .onEnded { value in
                    let snapDistance = maxHeight * Constants.snapRatio
                    withAnimation(.easeInOut) {
                        if value.translation.height < -snapDistance {
                            isProfileMode = true
                        } else if value.translation.height > snapDistance {
                            isProfileMode = false
                        }
                        currentOffset = isProfileMode ? 0 : maxHeight - minHeight
                    }
                    print("maxHeight on ended: \(maxHeight)")
                        print("minHeight on on ended: \(minHeight)")
                        print("initialOffset on ended: \(maxHeight - minHeight)")
                }
        )
        .onChange(of: isProfileMode) { newValue in
            withAnimation(.easeInOut) {
                currentOffset = newValue ? 0 : maxHeight - minHeight
                
                print("maxHeight on change: \(maxHeight)")
                print("minHeight on change: \(minHeight)")
                print("initialOffset on change: \(maxHeight - minHeight)")
            }
        }
        .onAppear {
            DispatchQueue.main.async{
                currentOffset = maxHeight - minHeight
                
                print("maxHeight on appear: \(maxHeight)")
                print("minHeight on appear: \(minHeight)")
                print("initialOffset on appear: \(maxHeight - minHeight)")
            }
            
        }
        
    }
}
