//
//  MapView.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 28.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//
import SwiftUI
import YandexMapsMobile

struct YandexMapsView: UIViewRepresentable {
    
    func makeUIView(context: Context) -> YMKMapView {
        let mapView = YMKMapView(frame: CGRect.zero)
                
        return mapView!
    }
         
    func updateUIView(_ uiView: YMKMapView, context: Context) {
             
    }
}
