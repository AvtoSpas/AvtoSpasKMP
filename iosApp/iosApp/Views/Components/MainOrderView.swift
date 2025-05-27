//
//  MainOrderView.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 08.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct MainOrderView: View {
    @ObservedObject var carViewModel: CarsViewModel
    
    var body: some View {
        VStack {
            VStack(alignment: .leading){
                HStack {
                    Image("DestinationMark").frame(width: 24, height: 24).padding(.trailing, 10)
                    VStack {
                        TextField("Откуда едем?", text: .constant(""))
                            .frame(width: 300, alignment: .center)
                            .padding(.bottom, 5)
                        RoundedRectangle(cornerRadius: 30)
                            .fill(Color.secondary)
                            .frame(width: 300, height: 2)
                    }
                }
                HStack {
                    Image("DestinationMark").frame(width: 24, height: 24).padding(.trailing, 10)
                    VStack {
                        TextField("Куда едем?", text: .constant(""))
                            .frame(width: 300, alignment: .center)
                            .padding(.bottom, 5)
                        RoundedRectangle(cornerRadius: 30)
                            .fill(Color.secondary)
                            .frame(width: 300, height: 2)
                    }
                }
            }
            .offset(x: -20)
            
            
            ScrollView(.horizontal, showsIndicators: false) {
                HStack(spacing: 10) {
                    ForEach(carViewModel.dataSource, id: \.name) { car in
                        CarCellView(car: car)
                            .onTapGesture {
                                print("Это машина \(car.name)")
                            }
                    }
                }
                .padding(.top, 15)
                .offset(x: 10)
            }
            
            HStack(spacing: 20) {
                Image("wallet").frame(width: 31, height: 32)
                Button(action: {}) {
                    Text("Заказать")
                        .foregroundColor(.white)
                        .font(.system(size: 16))
                        .frame(width: 275, height: 46)
                        .background(Color("MainPrimaryButtonColor"))
                        .cornerRadius(10)
                }
                Image("sliders").frame(width: 31, height: 32)
            }
            .frame(maxWidth: .infinity)
            .padding(.top, 10)
        }
    }
}

