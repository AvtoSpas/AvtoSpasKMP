//
//  CarCellView.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 17.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct CarCellView: View {
    let car: CarModel
    
    var body: some View {
        VStack(alignment: .leading) {
            
            Image(car.image)
                .resizable()
                .frame(width: 86, height: 46)
            
            Text(car.name)
                .font(.system(size: 8, weight: .medium))
                .lineLimit(2)
                .multilineTextAlignment(.leading)
                .fixedSize(horizontal: false, vertical: true)
                .padding(.top, 4)
            
            Text("\(car.price)₽")
                .font(.system(size: 8, weight: .bold))
                .padding(.top, 4)
        }
        .frame(width: 96, height: 103)
        .cornerRadius(10)
        .overlay(RoundedRectangle(cornerRadius: 10).stroke(Color("OutlineButtonColor"), lineWidth: 1))
    }
}


