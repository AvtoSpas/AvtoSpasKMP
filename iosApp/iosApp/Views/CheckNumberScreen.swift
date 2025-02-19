//
//  SwiftUIView.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 16.02.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct CheckNumberScreen: View {
    @Environment(\.colorScheme) var colorScheme
    @Environment(\.presentationMode) var presentationMode
    @State private var codeState = ""
    
    var body: some View {
        VStack(alignment: .center) {
            HStack {
                combinedText
                    .font(.system(size: 36))
                    .fontWeight(.bold)
            }
            .padding(.top, 20)
            VStack{
                Text("Код был отправлен на номер +7 (000) 000-00-00")
                    .foregroundStyle(colorScheme == .dark ? .white : .black)
                    .font(.system(size: 14))
                    .fontWeight(.bold)
                
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
                
                NavigationLink(destination: RegistrationNameScreen()) {
                    Text("Далее").foregroundColor(.white)
                        .font(.system(size: 16))
                        .fontWeight(.regular)
                        .frame(width: 348, height: 44)
                        .background(Color("MainPrimaryButtonColor"))
                        .cornerRadius(12)
                }
                .padding(.top, 20)
                
                Button(action: {}){
                    Text("Отправить сообщение еще раз").foregroundColor(colorScheme == .dark ? .white : Color("MainSecondaryTextColor"))
                        .font(.system(size: 16))
                        .fontWeight(.regular)
                        .frame(width: 348, height: 44)
                        .background(colorScheme == .dark ? Color("OutlineButtonColor") : .white)
                        .cornerRadius(10)
                }
                .overlay(RoundedRectangle(cornerRadius: 10).stroke(Color("OutlineButtonColor"), lineWidth: 2))
                .padding()
                
            }
            .padding(.top, 170)
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
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

#Preview {
    CheckNumberScreen()
}
