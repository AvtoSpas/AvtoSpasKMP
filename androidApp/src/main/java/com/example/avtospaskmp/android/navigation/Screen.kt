package com.example.avtospaskmp.android.navigation


sealed class Screen {
    object StartScreen : Screen()
    object PhoneScreen : Screen()
}