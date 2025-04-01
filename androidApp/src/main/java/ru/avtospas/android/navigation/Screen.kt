package ru.avtospas.android.navigation

import kotlinx.serialization.Serializable


sealed class Screen {
    @Serializable
    data object StartScreen : Screen()

    @Serializable
    data object SignUpScreen : Screen()

    @Serializable
    data object MainScreen : Screen()

    @Serializable
    data object EditProfileScreen : Screen()

    @Serializable
    data object OrderScreens : Screen()

    @Serializable
    data object SettingsScreen : Screen()

    @Serializable
    data object SupportScreen : Screen()

//    @Serializable
//    object PhoneScreen : Screen()
//
//    @Serializable
//    data class CodeScreen(val phoneNumberFrom: String) : Screen()
//
//    @Serializable
//    object FirstRegScreen : Screen()

}