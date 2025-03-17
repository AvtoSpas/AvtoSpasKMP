import SwiftUI
import shared

struct StartScreen: View {
    @Environment(\.colorScheme) var colorScheme
    
    var body: some View {
        NavigationView {
            VStack(alignment: .center) {
                HStack {
                    combinedText
                        .font(.system(size: 60))
                        .fontWeight(.bold)
                }
                .padding(.top, 50)
                Image("StartScreenImage")
                    .padding(.leading, 60)
                NavigationLink(destination: RegistrationNumberScreen()){
                    Text("Вход").foregroundColor(.white)
                        .font(.system(size: 20))
                        .frame(width: 348, height: 61)
                        .background(Color("MainPrimaryButtonColor"))
                        .cornerRadius(10)
                        .padding(.top, 70)
                }
                NavigationLink(destination: RegistrationNumberScreen()) {
                    Text("Регистрация").foregroundColor(colorScheme == .dark ? .white : Color("MainSecondaryTextColor"))
                        .font(.system(size: 20))
                        .frame(width: 348, height: 61)
                        .background(colorScheme == .dark ? Color("OutlineButtonColor") : .white)
                        .cornerRadius(10)
                }
                .overlay(RoundedRectangle(cornerRadius: 10).stroke(Color("OutlineButtonColor"), lineWidth: 2))
                .padding()
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
            .padding()
        }
        
        
    }
}
