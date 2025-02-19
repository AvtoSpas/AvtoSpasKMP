package com.example.avtospaskmp.android

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.avtospaskmp.android.navigation.Screen
import com.example.avtospaskmp.android.screens.StartScreen
import com.example.avtospaskmp.android.screens.PhoneScreen

@Composable
fun App() {
    var currentScreen by remember { mutableStateOf("startScreen") }

    when (currentScreen) {
        "startScreen" -> StartScreen(
            onNavigateToPhoneScreen = {currentScreen = "phoneScreen"}
        )
        "phoneScreen" -> PhoneScreen(
            onNavigateToStartScreen = {currentScreen = "startScreen"}
        )
    }
}