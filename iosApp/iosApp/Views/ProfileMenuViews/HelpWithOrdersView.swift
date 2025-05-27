//
//  HelpWithOrdersView.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 09.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct HelpWithOrdersView: View {
    @ObservedObject var ordersViewModel: OrdersViewModel
    @Environment(\.presentationMode) var presentationMode
    
    var body: some View {
        VStack(alignment: .leading, spacing: 16) {
            
            myHelpOrdersCombinedText
                .font(.system(size: 36))
                .fontWeight(.semibold)

            ScrollView(showsIndicators: false) {
                ForEach(ordersViewModel.dataSource, id: \.dateOfOrder) { order in
                    HelpOrderCellView(order: order)
                }
            }
        }
        .padding()
        .navigationBarBackButtonHidden(true)
        .navigationBarItems(leading: Button(action: {
            presentationMode.wrappedValue.dismiss()
        }) {
            Image(systemName: "chevron.left")
                .foregroundColor(Color("MainNameTextColor"))
        })
    }
}
