//
//  SwiftUIView.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 16.02.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct CheckNumberScreen: View {
    @ObservedObject private var keyboard = KeyboardResponder()
    @Environment(\.colorScheme) var colorScheme
    @Environment(\.presentationMode) var presentationMode
    @State private var codeState = ""
    
    let phoneNumber: String
    
    var body: some View {
        VStack(alignment: .center) {
            HStack {
                combinedText
                    .font(.system(size: 36))
                    .fontWeight(.bold)
            }
            Spacer()
            VStack{
                Text("Код был отправлен на номер: " + " \(phoneNumber)")
                    .foregroundStyle(colorScheme == .dark ? .white : .black)
                    .font(.system(size: 14))
                    .fontWeight(.bold)
                CustomCodeTextField(codeState: $codeState)
                PrimaryOrangeButton(
                    title: "Далее",
                    destination: RegistrationNameScreen(),
                    width: 348,
                    height: 44
                )
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
            Spacer()
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding(.bottom, keyboard.currentHeight)
        .animation(.easeOut(duration: 0.25), value: keyboard.currentHeight)
        .hideKeyboardOnTap()
        .navigationBarBackButtonHidden(true)
        .navigationBarItems(leading: Button(action: {
            presentationMode.wrappedValue.dismiss()
        }) {
            Image(systemName: "chevron.left")
                .foregroundColor(Color("MainNameTextColor"))
        })
    }
    
}

#Preview {
    CheckNumberScreen(phoneNumber: "+7 (913) 123-45-67")
}
