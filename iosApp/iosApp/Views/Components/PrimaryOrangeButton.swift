//
//  PrimaryOrangeButton.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 05.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct PrimaryOrangeButton<Destination: View>: View {
    let title: String
    let destination: Destination
    let width: CGFloat
    let height: CGFloat
    
    var body: some View {
        NavigationLink(destination: destination) {
            Text(title).foregroundColor(.white)
                .font(.system(size: 16))
                .fontWeight(.regular)
                .frame(width: width, height: height)
                .background(Color("MainPrimaryButtonColor"))
                .cornerRadius(12)
            
        }
    }
}
