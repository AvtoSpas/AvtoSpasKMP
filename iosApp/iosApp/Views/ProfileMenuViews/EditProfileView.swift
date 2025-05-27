//
//  EditProfileView.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 09.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct EditProfileView: View {
    @State private var firstName = "Иван"
    @State private var lastName = "Иванов"
    @Environment(\.presentationMode) var presentationMode
    
    var body: some View {
        VStack {
            VStack(spacing: 20) {
                
                editProfileCombinedText
                    .multilineTextAlignment(.center)
                    .font(.system(size: 36))
                    .fontWeight(.semibold)
                    .padding(.top, 40)
                
                
                HStack(alignment: .center) {
                    Circle()
                        .overlay(
                            Image("Igoryambus")
                                .resizable()
                                .aspectRatio(contentMode: .fill)
                                .clipShape(.circle)
                                .padding(2)
                        )
                        .frame(width: 77, height: 79)
                    
                    VStack(alignment: .leading, spacing: 4) {
                        Text("Иван Иванов")
                            .font(.system(size: 24))
                            .fontWeight(.bold)
                            .foregroundColor(.black)
                        
                        Button(action: {}) {
                            Text("ЗАГРУЗИТЬ ИЗОБРАЖЕНИЕ")
                                .font(.caption)
                                .fontWeight(.semibold)
                                .foregroundColor(.black)
                                .padding(.horizontal, 8)
                                .padding(.vertical, 4)
                                .background(Color.gray.opacity(0.2))
                                .cornerRadius(8)
                        }
                    }
                    
                    Spacer()
                }
                .padding(.top, 100)
                
                Text("Имя и фамилия")
                    .font(.subheadline)
                    .foregroundColor(.gray)
                    .padding(.top, 10)
                
                VStack(spacing: 12) {
                    TextField("Иван", text: $firstName)
                        .padding()
                        .multilineTextAlignment(.center)
                        .frame(height: 44)
                        .background(Color("MainSecondaryButtonColor"))
                        .cornerRadius(12)
                        .overlay(RoundedRectangle(cornerRadius: 10)
                            .stroke(Color("OutlineButtonColor"), lineWidth: 2))
                    
                    TextField("Иванов", text: $lastName)
                        .padding()
                        .multilineTextAlignment(.center)
                        .frame(height: 44)
                        .background(Color("MainSecondaryButtonColor"))
                        .cornerRadius(12)
                        .overlay(RoundedRectangle(cornerRadius: 10)
                            .stroke(Color("OutlineButtonColor"), lineWidth: 2))
                }
            }
            .padding(.horizontal, 24)
            
            Spacer()
            
            Button(action: {}) {
                Text("Сохранить изменения")
                    .foregroundColor(.white)
                    .font(.system(size: 16))
                    .frame(maxWidth: .infinity, minHeight: 44)
                    .background(Color("MainPrimaryButtonColor"))
                    .cornerRadius(12)
            }
            .padding(.horizontal, 24)
            .padding(.bottom, 30)
        }
        .frame(maxHeight: .infinity)
        .navigationBarBackButtonHidden(true)
        .navigationBarItems(leading: Button(action: {
            presentationMode.wrappedValue.dismiss()
        }) {
            Image(systemName: "chevron.left")
                .foregroundColor(Color("MainNameTextColor"))
        })
        
    }
    
}

