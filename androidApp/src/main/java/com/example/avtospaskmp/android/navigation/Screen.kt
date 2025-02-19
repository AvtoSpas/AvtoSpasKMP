package com.example.avtospaskmp.android.navigation


sealed class Screen {
    object StartScreen : Screen()
    object PhoneScreen : Screen()
    data class CodeScreen(val phoneNumberFrom: String) : Screen()
    object FirstRegScreen : Screen()
}