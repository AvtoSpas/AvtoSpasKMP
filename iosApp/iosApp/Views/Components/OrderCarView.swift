//
//  OrderCarView.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 06.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct OrderCarView: View {
    @State private var carBrand = ""
    @State private var carModel = ""
    @State private var licensePlate = ""

    var body: some View {
        ScrollView {
            VStack(spacing: 16) {
                CustomTextField(title: "Марка", text: $carBrand)
                CustomTextField(title: "Модель", text: $carModel)
                CustomTextField(title: "Номер автомобиля", text: $licensePlate)
                Button(action: {}) {
                    Text("Заказать")
                        .foregroundColor(.white)
                        .font(.system(size: 16))
                        .frame(width: 348, height: 44)
                        .background(Color("MainPrimaryButtonColor"))
                        .cornerRadius(10)
                }
                .frame(maxWidth: .infinity)
                .padding()

            }
            .padding()
        }
    }
}
