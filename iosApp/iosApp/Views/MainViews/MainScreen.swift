//
//  MainScreen.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 13.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct MainScreen: View {
    @State private var bottomSheetShown = false
    @State private var isProfileMode = false
    @State private var isOrderingCar = false
    @StateObject private var carViewModel = CarsViewModel()

    var body: some View {
        ZStack {
            YandexMapsView()
                .edgesIgnoringSafeArea(.all)

            // MARK: - Кнопки управления картой
            VStack {
                Spacer()

                VStack(spacing: 12) {
                    Button(action: {
                        // Увеличение масштаба карты
                    }) {
                        Image(systemName: "plus")
                            .font(.system(size: 20, weight: .medium))
                            .foregroundColor(.black)
                            .frame(width: 20, height: 20)
                            .padding()
                            .background(Color.white)
                            .clipShape(Circle())
                    }

                    Button(action: {
                        // Уменьшение масштаба карты
                    }) {
                        Image(systemName: "minus")
                            .font(.system(size: 20, weight: .medium))
                            .foregroundColor(.black)
                            .frame(width: 20, height: 20)
                            .padding()
                            .background(Color.white)
                            .clipShape(Circle())
                    }
                }
                .background(Color.white)
                .cornerRadius(16)
                .shadow(color: .black.opacity(0.1), radius: 4, x: 0, y: 2)
                .padding(.trailing, 16)

                Button(action: {
                    // Центрирование карты
                }) {
                    Image(systemName: "location.fill")
                        .font(.system(size: 20, weight: .medium))
                        .foregroundColor(.black)
                        .frame(width: 20, height: 20)
                        .padding()
                        .background(Color.white)
                        .clipShape(Circle())
                        .shadow(color: .black.opacity(0.1), radius: 4, x: 0, y: 2)
                }
                .padding(.top, 12)
                .padding(.bottom, 350)
                .padding(.trailing, 16)
            }
            .frame(maxWidth: .infinity, alignment: .trailing)

            // MARK: - Верхняя панель поиска и аватар
            VStack {
                HStack {
                    HStack {
                        Image("FindMark").frame(width: 24, height: 24)
                        TextField("Найдем адрес тут?", text: .constant(""))
                            .frame(width: 233, height: 28)
                    }
                    .frame(width: 273, height: 28)
                    .padding()
                    .background(Color.white)
                    .cornerRadius(20)

                    ZStack(alignment: .topTrailing) {
                        Circle()
                            .overlay(
                                Image("Igoryambus")
                                    .resizable()
                                    .aspectRatio(contentMode: .fill)
                                    .clipShape(.circle)
                                    .padding(2)
                            )
                            .frame(width: 77, height: 79)

                        Text("4,9")
                            .font(.system(size: 8))
                            .font(.system(size: 18, weight: .bold))
                            .foregroundColor(.black)
                            .padding(.horizontal, 8)
                            .padding(.vertical, 4)
                            .background(Color.white)
                            .clipShape(RoundedRectangle(cornerRadius: 10))
                    }
                }

                // MARK: - BottomSheetView
                GeometryReader { geometry in
                    BottomSheetView(
                        maxHeight: 787.0,
                        isProfileMode: $isProfileMode,
                        isOrderingCar: $isOrderingCar
                    ) {
                        if isProfileMode {
                            ProfileMenuView()
                                .frame(maxHeight: .infinity, alignment: .top)
                        } else if isOrderingCar {
                            OrderCarView()
                                .frame(maxHeight: .infinity, alignment: .top)
                        } else {
                            MainOrderView(
                                carViewModel: carViewModel,
                                isOrderingCar: $isOrderingCar
                            )
                            .frame(maxHeight: .infinity, alignment: .top)
                        }
                    }
                }
                .edgesIgnoringSafeArea(.all)
            }
        }
        .onAppear {
            bottomSheetShown = false
            isProfileMode = false
        }
        .navigationBarBackButtonHidden(true)
    }
}

#Preview {
    MainScreen()
}

