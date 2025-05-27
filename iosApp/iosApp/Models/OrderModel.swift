//
//  CarModel.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 17.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation


struct OrderModelList: Codable {
    let orders: [OrderModel]
}

struct OrderModel: Codable {
    let dateOfOrder: String
    let timeOfOrder: String
    let imageTruck: String
    let adress: String
    let price: Int
}

let dataOfOrders = OrderModelList(
    orders:[
        OrderModel(dateOfOrder: "Сегодня, четверг", timeOfOrder: "7:01", imageTruck: "TruckScrollViewImage", adress: "Чайковского, 10", price: 5000),
        OrderModel(dateOfOrder: "19 июня, среда", timeOfOrder: "7:01", imageTruck: "TruckScrollViewImage", adress: "Чайковского, 10", price: 5000),
        OrderModel(dateOfOrder: "28 декабря 2023, четверг", timeOfOrder: "7:01", imageTruck: "TruckScrollViewImage", adress: "Чайковского, 10", price: 5000),
        OrderModel(dateOfOrder: "18 ноября 2023, суббота", timeOfOrder: "7:01", imageTruck: "TruckScrollViewImage", adress: "Чайковского, 10", price: 5000),
        OrderModel(dateOfOrder: "18 марта 2022, пятница", timeOfOrder: "7:01", imageTruck: "TruckScrollViewImage", adress: "Чайковского, 10", price: 5000),
        OrderModel(dateOfOrder: "2 января 2022, воскресенье", timeOfOrder: "7:01", imageTruck: "TruckScrollViewImage", adress: "Чайковского, 10", price: 5000),
        OrderModel(dateOfOrder: "1 января 2022, воскресенье", timeOfOrder: "7:01", imageTruck: "TruckScrollViewImage", adress: "Чайковского, 10", price: 5000),
        OrderModel(dateOfOrder: "29 декабря 2021, четверг", timeOfOrder: "7:01", imageTruck: "TruckScrollViewImage", adress: "Чайковского, 10", price: 5000),
        OrderModel(dateOfOrder: "27 декабря 2021, суббота", timeOfOrder: "7:01", imageTruck: "TruckScrollViewImage", adress: "Чайковского, 10", price: 5000),
        OrderModel(dateOfOrder: "26 декабря 2021, пятница", timeOfOrder: "7:01", imageTruck: "TruckScrollViewImage", adress: "Чайковского, 10", price: 5000),
        OrderModel(dateOfOrder: "24 декабря 2021, среда", timeOfOrder: "7:01", imageTruck: "TruckScrollViewImage", adress: "Чайковского, 10", price: 5000),
        
    ]
)
