//
//  OrderCellView.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 10.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct OrderCellView: View {
    let order: OrderModel
    
    var body: some View {
        VStack(alignment: .leading){
            Text(order.dateOfOrder)
                .font(.system(size: 24))
                .foregroundStyle(.gray)
                .bold()
            HStack(alignment: .top, spacing: 8) {
                VStack(alignment: .leading, spacing: 4) {
                    Text("Эвакуация, в " + order.timeOfOrder)
                        .bold()
                    Text("\(order.price)₽, улица " + order.adress)
                }
                Image(order.imageTruck)
                    .resizable()
                    .frame(width: 86, height: 46)
            }
            .padding()
            .background(Color(.systemGray6))
            .cornerRadius(12)
        }
    }
}

struct HelpOrderCellView: View {
    let order: OrderModel
    
    var body: some View {
        VStack(alignment: .leading){
            Text(order.dateOfOrder)
                .font(.system(size: 24))
                .foregroundStyle(.gray)
                .bold()
            HStack(alignment: .top, spacing: 8) {
                VStack(alignment: .leading, spacing: 4) {
                    Text("Эвакуация, в " + order.timeOfOrder)
                        .bold()
                    Text("\(order.price)₽, улица " + order.adress)
                    Text("Помощь").font(.footnote)
                }
                Image(order.imageTruck)
                    .resizable()
                    .frame(width: 86, height: 46)
            }
            .padding()
            .background(Color(.systemGray6))
            .cornerRadius(12)
        }
    }
}
