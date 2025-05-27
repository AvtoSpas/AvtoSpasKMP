//
//  ProfileMenuView.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 08.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct ProfileMenuView: View {
    @StateObject private var orderViewModel = OrdersViewModel()
    
    var body: some View {
        VStack(alignment: .leading, spacing: 16) {
            HStack {
                Circle()
                    .overlay(
                        Image("Igoryambus")
                            .resizable()
                            .aspectRatio(contentMode: .fill)
                            .clipShape(.circle)
                            .padding(2)
                    )
                    .frame(width: 77, height: 79)
                
                VStack(alignment: .leading) {
                    Text("Иван Иванов")
                        .font(.headline)
                    NavigationLink(destination: EditProfileView()) {
                        Text("РЕДАКТИРОВАТЬ ПРОФИЛЬ")
                            .font(.caption)
                            .fontWeight(.semibold)
                    }
                    .foregroundColor(.black)
                    .padding(6)
                    .background(Color.gray.opacity(0.2))
                    .cornerRadius(8)
                }
                
                Spacer()
                
                HStack{
                    Text("Рейтинг").font(.subheadline).foregroundColor(.gray)
                    Text("4,9")
                        .font(.title3)
                        .fontWeight(.bold)
                }
            }
            
            
            VStack(alignment: .leading, spacing: 35) {
                VStack(alignment: .leading){
                    Text("Мое местоположение").font(.subheadline).foregroundColor(.gray)
                    Text("Омск, улица Труда, 9А")
                }
                .frame(maxHeight: 48)
                
                NavigationLink(destination: HistoryOrdersView(ordersViewModel: orderViewModel)) {
                    Text("История заказов")
                        .foregroundColor(.black)
                }
                
                NavigationLink(destination: HelpWithOrdersView(ordersViewModel: orderViewModel)) {
                    Text("Служба поддержки")
                        .foregroundColor(.black)
                    
                }
                NavigationLink(destination: UserSettingsView()) {
                    Text("Настройки")
                        .foregroundColor(.black)
                }
            }
            
            Spacer()
            
            NavigationLink(destination: StartScreen()) {
                HStack{
                    Image("image-user-left").frame(width: 24, height: 24)
                    Text("Выйти из аккаунта")
                        .foregroundColor(.black)
                        .font(.system(size: 16))
                        .frame(width: 160, height: 24)
                }
            }
            .padding(.bottom, 20)
            
        }
        .padding()
    }
}


#Preview {
    ProfileMenuView()
}
