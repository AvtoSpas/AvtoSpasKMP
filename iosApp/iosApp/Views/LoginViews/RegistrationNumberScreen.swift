import SwiftUI
import Combine
import shared

struct RegistrationNumberScreen: View {
    @ObservedObject private var keyboard = KeyboardResponder()
    @Environment(\.colorScheme) var colorScheme
    @Environment(\.presentationMode) var presentationMode
    @State public var phoneNumber = "+7 "
    
    var body: some View {
        VStack(alignment: .center) {
            HStack {
                combinedText
                    .font(.system(size: 36))
                    .fontWeight(.bold)
            }
            Spacer()
            VStack{
                Text("Введите номер телефона")
                    .foregroundStyle(colorScheme == .dark ? .white : .black)
                    .font(.system(size: 14))
                    .fontWeight(.bold)
                CustomPhoneTextField(phoneNumber: $phoneNumber)
                PrimaryOrangeButton(
                    title: "Далее",
                    destination: CheckNumberScreen(phoneNumber: phoneNumber),
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


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        StartScreen()
    }
}
