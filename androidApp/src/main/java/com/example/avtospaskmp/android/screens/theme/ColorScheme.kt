package com.example.avtospaskmp.android.screens.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color


@Immutable
data class ColorScheme(
    val orangeColor: Color = Color(0xffE53B19),
    val defWhiteDark: Color = Color.Unspecified,
    val defDarkWhite: Color = Color.Unspecified,
    val defOrangeWhite: Color = Color.Unspecified,
    val grayButton: Color = Color.Unspecified,
    val grayButtonBorder: Color = Color.Unspecified,
    val white: Color = Color.White,
    val dark: Color = Color.Black
)

val OnLightColorScheme = ColorScheme(
    defWhiteDark = Color.White,
    defDarkWhite = Color.Black,
    defOrangeWhite = Color(0xffE53B19),
    grayButton = Color.White,
    grayButtonBorder = Color(0xffE8E7E7)
)
val  OnDarkColorScheme = ColorScheme(
    defWhiteDark = Color.Black,
    defDarkWhite = Color.White,
    defOrangeWhite = Color.White,
    grayButton = Color(0xFF404040),
    grayButtonBorder = Color(0xFF404040)
)