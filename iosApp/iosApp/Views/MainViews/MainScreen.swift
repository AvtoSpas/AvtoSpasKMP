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
    @StateObject private var carViewModel = CarsViewModel()
    
    var body: some View {
        GeometryReader { geometry in
            
            BottomSheetView(
                isOpen: self.$bottomSheetShown,
                maxHeight: geometry.size.height * 0.7
            ) {
                VStack{
                    VStack{
                        VStack{
                            HStack{
                                Image("DestinationMark")
                                TextField("Откуда едем?", text: .constant("")).padding(.leading, 2)
                            }
                            .padding(.bottom, 5)
                            RoundedRectangle(cornerRadius: 30)
                                .fill(Color.secondary)
                                .frame(width: 300, height: 2)
                        }
                        .padding(.top, 10)
                        VStack{
                            HStack{
                                Image("DestinationMark")
                                TextField("Куда едем?", text: .constant("")).padding(.leading, 2)
                            }
                            .padding(.bottom, 5)
                            RoundedRectangle(cornerRadius: 30)
                                .fill(Color.secondary)
                                .frame(width: 300, height: 2)
                        }
                        .padding(.top, 10)
                    }
                    .padding(.leading, 20)
                    
                    ScrollView(.horizontal, showsIndicators: false){
                        HStack(spacing: 10){
                            ForEach(carViewModel.dataSource, id: \.name){ car in
                                CarCellView(car: car)
                                    .onTapGesture {
                                        print("Это машина \(car.name)")
                                    }
                            }
                        }
                    }
                    .padding(.top, 15)
                    .offset(x: 10)
                    HStack(alignment: .center, spacing: 20){
                        Image("wallet")
                        Button(action: {}) {
                            Text("Вход").foregroundColor(.white)
                                .font(.system(size: 16))
                                .frame(width: 246, height: 46)
                                .background(Color("MainPrimaryButtonColor"))
                                .cornerRadius(10)

                        }
                        Image("sliders")
                    }
                    .padding(.top, 10)
                }
                
            }
        }
        .edgesIgnoringSafeArea(.all)
        .navigationBarBackButtonHidden(true)
    }
    
}

#Preview {
    MainScreen()
}

