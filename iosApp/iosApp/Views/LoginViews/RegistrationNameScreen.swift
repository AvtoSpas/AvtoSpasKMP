//
//  Untitled.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 16.02.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct RegistrationNameScreen: View {
    @ObservedObject private var keyboard = KeyboardResponder()
    @Environment(\.colorScheme) var colorScheme
    @Environment(\.presentationMode) var presentationMode
    @State var nameState: String = ""
    @State var surnameState: String = ""
    
    var body: some View {
        VStack(alignment: .center) {
            HStack {
                combinedText
                    .font(.system(size: 36))
                    .fontWeight(.bold)
            }
            Spacer()
            VStack{
                Text("Введите данные о себе")
                    .foregroundStyle(colorScheme == .dark ? .white : .black)
                    .font(.system(size: 14))
                    .fontWeight(.bold)
                CustomTextField(title: "Иван", text: $nameState)
                CustomTextField(title: "Иванов", text: $surnameState).padding(.top, 5)
                PrimaryOrangeButton(
                    title: "Далее",
                    destination: MainScreen(),
                    width: 348,
                    height: 44
                )
                .padding(.top, 20)
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


