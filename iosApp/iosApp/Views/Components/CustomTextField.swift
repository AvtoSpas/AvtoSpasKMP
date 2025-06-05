//
//  CustomTextField.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 05.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct CustomTextField: View {
    let title: String
    @Binding var text: String
    
    var body: some View {
        TextField(title, text: $text)
            .padding()
            .multilineTextAlignment(.center)
            .frame(width: 348, height: 44)
            .background(Color("MainSecondaryButtonColor"))
            .cornerRadius(12)
            .overlay(RoundedRectangle(cornerRadius: 10).stroke(Color("OutlineButtonColor"), lineWidth: 2))
    }
}
