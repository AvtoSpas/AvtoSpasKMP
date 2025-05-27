//
//  CarsViewModel.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 17.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation


class OrdersViewModel: ObservableObject {
    @Published var dataSource: [OrderModel] = []
    
    init() {
        updateDataSource()
    }
    
    func updateDataSource() {
        self.dataSource = dataOfOrders.orders
    }
}
