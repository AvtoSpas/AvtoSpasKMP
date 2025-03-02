package ru.avtospas.android.navigation

import kotlinx.serialization.Serializable


sealed class Screen {
    @Serializable
    object StartScreen : Screen()

    @Serializable
    object PhoneScreen : Screen()

    @Serializable
    data class CodeScreen(val phoneNumberFrom: String) : Screen()

    @Serializable
    object FirstRegScreen : Screen()
}