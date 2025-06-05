//
//  Untitled.swift
//  iosApp
//
//  Created by Stepan Kolenkin on 11.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

extension View {
    func hideKeyboardOnTap() -> some View {
        self.onTapGesture {
            UIApplication.shared.sendAction(#selector(UIResponder.resignFirstResponder),
                                            to: nil, from: nil, for: nil)
        }
    }
}
