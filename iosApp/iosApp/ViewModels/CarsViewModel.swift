//
//  CarsViewModel.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 17.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation


class CarsViewModel: ObservableObject {
    @Published var dataSource: [CarModel] = []
    
    init() {
        updateDataSource()
    }
    
    func updateDataSource() {
        self.dataSource = dataOfCars.cars
    }
}
