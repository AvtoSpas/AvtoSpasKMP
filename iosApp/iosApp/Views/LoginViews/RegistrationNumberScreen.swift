import SwiftUI
import Combine
import shared

struct RegistrationNumberScreen: View {
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
            .padding(.top, 20)
            VStack{
                Text("Введите номер телефона")
                    .foregroundStyle(colorScheme == .dark ? .white : .black)
                    .padding(.top, 10)
                     .font(.system(size: 14))
                    .fontWeight(.bold)
                
                TextField("+7 (000) 000-00-00", text: $phoneNumber)
                    .padding()
                    .keyboardType(.numberPad)
                    .frame(width: 348, height: 44)
                    .background(Color("MainSecondaryButtonColor"))
                    .cornerRadius(12)
                    .overlay(RoundedRectangle(cornerRadius: 10).stroke(Color("OutlineButtonColor"), lineWidth: 2))
                    .onChange(of: phoneNumber) { newValue in
                        phoneNumber = formatPhoneNumber(newValue)
                        
                    }
                
                NavigationLink(destination: CheckNumberScreen(phoneNumber: phoneNumber)) {
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
    func formatPhoneNumber(_ phoneNumber: String) -> String {
        let cleanPhoneNumber = phoneNumber.components(separatedBy: CharacterSet.decimalDigits.inverted).joined()
        let mask = "+X (XXX) XXX-XX-XX"
        
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
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        StartScreen()
    }
}
