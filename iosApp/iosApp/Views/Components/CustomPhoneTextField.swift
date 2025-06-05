//
//  CustomPhoneTextField.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 05.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct CustomPhoneTextField: View {
    @Binding var phoneNumber: String
    
    var body: some View {
        TextField("+7 (000) 000-00-00", text: $phoneNumber)
            .padding()
            .keyboardType(.numberPad)
            .frame(width: 348, height: 44)
            .background(Color("MainSecondaryButtonColor"))
            .cornerRadius(12)
            .overlay(RoundedRectangle(cornerRadius: 10).stroke(Color("OutlineButtonColor"), lineWidth: 2))
            .onChange(of: phoneNumber) { newValue in
                phoneNumber = formatPhoneNumber(newValue)
            }
    }
    func formatPhoneNumber(_ phoneNumber: String) -> String {
        let cleanPhoneNumber = phoneNumber.components(separatedBy: CharacterSet.decimalDigits.inverted).joined()
        let mask = "+X (XXX) XXX-XX-XX"
        
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
