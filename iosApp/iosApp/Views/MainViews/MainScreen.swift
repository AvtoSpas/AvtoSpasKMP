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
    @StateObject private var carViewModel = CarsViewModel()
    
    var body: some View {
        ZStack {
            YandexMapsView()
                .edgesIgnoringSafeArea(.all)
            
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
                
                GeometryReader { geometry in
                    BottomSheetView(
                        maxHeight: geometry.size.height * 1,
                        isProfileMode: $isProfileMode
                    ) {
                        if isProfileMode {
                            ProfileMenuView()
                                .frame(maxHeight: .infinity, alignment: .top)
                        } else {
                            MainOrderView(carViewModel: carViewModel)
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

