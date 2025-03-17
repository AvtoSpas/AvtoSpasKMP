//
//  CarModel.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 17.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation


struct CarModelList: Codable {
    let cars: [CarModel]
}

struct CarModel: Codable {
    let image: String
    let name: String
    let price: Int
}

let dataOfCars = CarModelList(
    cars:[
        CarModel(image: "TruckScrollViewImage", name: "Со сдвижной платформой", price: 5000),
        CarModel(image: "TruckScrollViewImage", name: "Со сдвижной платформой", price: 5000),
        CarModel(image: "TruckScrollViewImage", name: "Со сдвижной платформой", price: 5000),
        CarModel(image: "TruckScrollViewImage", name: "Со сдвижной платформой", price: 5000),
        CarModel(image: "TruckScrollViewImage", name: "Со сдвижной платформой", price: 5000)
    ]
)
