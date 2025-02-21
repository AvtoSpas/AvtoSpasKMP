package com.example.avtospaskmp.android

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.avtospaskmp.android.navigation.Screen
import com.example.avtospaskmp.android.screens.CodeScreen
import com.example.avtospaskmp.android.screens.FirstRegScreen
import com.example.avtospaskmp.android.screens.StartScreen
import com.example.avtospaskmp.android.screens.PhoneScreen
import com.example.avtospaskmp.android.screens.theme.ColorScheme

@Composable
fun App(colorScheme: ColorScheme) {
    var currentScreen by remember { mutableStateOf("startScreen") }
    var phoneNumber by remember { mutableStateOf("Initial phone") }

    when (currentScreen) {
        "startScreen" -> StartScreen(colorScheme,
            onNavigateToPhoneScreen = {currentScreen = "phoneScreen"}
        )
        "phoneScreen" -> PhoneScreen(
            onNavigateToStartScreen = {

                currentScreen = "startScreen"},
            onNavigateToCodeScreen = { phoneNumberFrom ->
                phoneNumber = phoneNumberFrom // Сохраняем номер
                currentScreen = "codeScreen"
            }
        )
        "codeScreen" -> CodeScreen(
            phoneNumber = phoneNumber,
            onNavigateToPhoneScreen = {currentScreen = "phoneScreen"},
            onNavigateToFirstRegScreen = {currentScreen = "firstRegScreen"}
        )
        "firstRegScreen" -> FirstRegScreen(
            onNavigateToCodeScreen = {currentScreen = "codeScreen"}
        )

    }
}