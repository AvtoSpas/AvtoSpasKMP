//
//  CustomCodeTextField.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 05.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct CustomCodeTextField: View {
    @Binding var codeState: String
    
    var body: some View {
        TextField("000-000", text: $codeState)
            .padding()
            .keyboardType(.numberPad)
            .multilineTextAlignment(.center)
            .frame(width: 348, height: 44)
            .background(Color("MainSecondaryButtonColor"))
            .cornerRadius(12)
            .overlay(RoundedRectangle(cornerRadius: 10).stroke(Color("OutlineButtonColor"), lineWidth: 2))
            .onChange(of: codeState) { newValue in
                codeState = formatCode(newValue)
            }
    }
    func formatCode(_ phoneNumber: String) -> String {
        let cleanPhoneNumber = phoneNumber.components(separatedBy: CharacterSet.decimalDigits.inverted).joined()
        
        let mask = "XXX-XXX"
        
        var result = ""
        var index = cleanPhoneNumber.startIndex
        
        for ch in mask where index < cleanPhoneNumber.endIndex {
            if ch == "X" {
                result.append(cleanPhoneNumber[index])
                index = cleanPhoneNumber.index(index, offsetBy: 1)
            } else {
                result.append(ch)
            }
        }
        
        return result
        
    }
}
