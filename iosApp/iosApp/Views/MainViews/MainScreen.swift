//
//  MainScreen.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 13.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct MainScreen: View {
    @State private var bottomSheetShown = false

        var body: some View {
            GeometryReader { geometry in
                
                BottomSheetView(
                    isOpen: self.$bottomSheetShown,
                    maxHeight: geometry.size.height * 0.7
                ) {
                    VStack{
                        HStack{
                            Image("DestinationMark")
                            TextField("Откуда едем?", text: .constant(""))
                                
                        }
                        .padding(.vertical, 10)
                        .padding(.horizontal, 30)
                        
                        RoundedRectangle(cornerRadius: 30)
                            .fill(Color.secondary)
                            .frame(width: 300, height: 2)
                        
                        HStack{
                            Image("DestinationMark")
                            TextField("Куда едем?", text: .constant(""))
                        }
                        .padding(.vertical, 10)
                        .padding(.horizontal, 30)
                        
                        RoundedRectangle(cornerRadius: 30)
                            .fill(Color.secondary)
                            .frame(width: 300, height: 2)
                    }
                }
            }.edgesIgnoringSafeArea(.all)
            .navigationBarBackButtonHidden(true)
        }
        
}

#Preview {
    MainScreen()
}

