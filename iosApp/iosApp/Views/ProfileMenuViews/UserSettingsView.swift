//
//  UserSettingsView.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 09.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct UserSettingsView: View {
    @State private var isDarkMode = false
    @State private var notificationsEnabled = false
    @Environment(\.presentationMode) var presentationMode

    var body: some View {
        VStack(alignment: .leading, spacing: 20) {
            Text("Настройки")
                .font(.title)
                .bold()

            Toggle("Темная тема", isOn: $isDarkMode)

            Divider()

            Text("Уведомления")
                .font(.headline)

            Toggle("Включить все уведомления", isOn: $notificationsEnabled)

            Spacer()
        }
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

#Preview {
    UserSettingsView()
}
