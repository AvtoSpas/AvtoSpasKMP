//
//  Untitled.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 16.02.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct RegistrationNameScreen: View {
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
            .padding(.top, 20)
            VStack{
                Text("Введите данные о себе")
                    .foregroundStyle(colorScheme == .dark ? .white : .black)
                    .font(.system(size: 14))
                    .fontWeight(.bold)
                
                TextField("Иван", text: $nameState)
                    .padding()
                    .multilineTextAlignment(.center)
                    .frame(width: 348, height: 44)
                    .background(Color("MainSecondaryButtonColor"))
                    .cornerRadius(12)
                    .overlay(RoundedRectangle(cornerRadius: 10).stroke(Color("OutlineButtonColor"), lineWidth: 2))
                
                TextField("Иванов", text: $surnameState)
                    .padding()
                    .multilineTextAlignment(.center)
                    .frame(width: 348, height: 44)
                    .background(Color("MainSecondaryButtonColor"))
                    .cornerRadius(12)
                    .overlay(RoundedRectangle(cornerRadius: 10).stroke(Color("OutlineButtonColor"), lineWidth: 2))
                    .padding(.top, 10)
                 
                NavigationLink(destination: MainScreen()) {
                    Text("Далее").foregroundColor(.white)
                        .font(.system(size: 16))
                        .fontWeight(.regular)
                        .frame(width: 348, height: 44)
                        .background(Color("MainPrimaryButtonColor"))
                        .cornerRadius(12)
                }
                .padding(.top, 20)
                
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
