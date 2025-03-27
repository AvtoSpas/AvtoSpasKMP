package ru.avtospas.core_ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class AvtoSpasColorScheme internal constructor(
    val corporateOrangeColor: Color = Color(0xffE53B19),
    val defWhiteBlack: Color = Color.Unspecified,
    val defBlackWhite: Color = Color.Unspecified,
    val defCorporateOrangeWhite: Color = Color.Unspecified,
    val grayButton: Color = Color.Unspecified,
    val grayButtonBorder: Color = Color.Unspecified,
    val white: Color = Color.White,
    val black: Color = Color.Black,
    val lightGray: Color = Color.LightGray,
    val searchIconColor : Color = Color.Unspecified,
    val whiteGray: Color = Color.Unspecified,
    val blackGray: Color = Color.Unspecified,
    val darkLightGray:Color = Color.Unspecified

) {
    companion object {
        val Light = AvtoSpasColorScheme(
            defWhiteBlack = Color.White,
            defBlackWhite = Color.Black,
            defCorporateOrangeWhite = Color(0xffE53B19),
            grayButton = Color.White,
            grayButtonBorder = Color(0xffE8E7E7),
            searchIconColor = Color(0xff96594F),
            whiteGray = Color.White,
            blackGray = Color.Black,
            darkLightGray = Color(0xFF404040)
        )

        val Dark = AvtoSpasColorScheme(
            defWhiteBlack = Color.Black,
            defBlackWhite = Color.White,
            defCorporateOrangeWhite = Color.White,
            grayButton = Color(0xFF404040),
            grayButtonBorder = Color(0xFF404040),
            searchIconColor = Color.White,
            whiteGray = Color(0xFF121212),
            blackGray = Color(0xFF121212),
            darkLightGray = Color.LightGray
        )
    }
}

