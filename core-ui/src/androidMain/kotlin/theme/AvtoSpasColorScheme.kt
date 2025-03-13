package ru.avtospas.core_ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class AvtoSpasColorScheme internal constructor(
    val orangeColor: Color = Color(0xffE53B19),
    val defWhiteDark: Color = Color.Unspecified,
    val defDarkWhite: Color = Color.Unspecified,
    val defOrangeWhite: Color = Color.Unspecified,
    val grayButton: Color = Color.Unspecified,
    val grayButtonBorder: Color = Color.Unspecified,
    val white: Color = Color.White,
    val dark: Color = Color.Black,
    val searchIconColor : Color = Color.Unspecified,
    val whiteGray: Color = Color.Unspecified,
    val darkGray: Color = Color.Unspecified
) {
    companion object {
        val Light = AvtoSpasColorScheme(
            defWhiteDark = Color.White,
            defDarkWhite = Color.Black,
            defOrangeWhite = Color(0xffE53B19),
            grayButton = Color.White,
            grayButtonBorder = Color(0xffE8E7E7),
            searchIconColor = Color(0xff96594F),
            whiteGray = Color.White,
            darkGray = Color.Black
        )

        val Dark = AvtoSpasColorScheme(
            defWhiteDark = Color.Black,
            defDarkWhite = Color.White,
            defOrangeWhite = Color.White,
            grayButton = Color(0xFF404040),
            grayButtonBorder = Color(0xFF404040),
            searchIconColor = Color.White,
            whiteGray = Color(0xFF121212),
            darkGray = Color(0xFF121212)
        )
    }
}

