package ru.avtospas.core_ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AvtoSpasTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        AvtoSpasColorScheme.Dark
    } else {
        AvtoSpasColorScheme.Light
    }

    val materialColors = if (darkTheme) {
        darkColorScheme(primaryContainer = Color(0xFFE53B1A))
    } else {
        lightColorScheme(primaryContainer = Color(0xFFE53B1A))
    }

    val typography = Typography(
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialThemeWrapper(
        materialColorScheme = materialColors,
        avtoSpasColors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

@Composable
fun MaterialThemeWrapper(
    materialColorScheme: ColorScheme,
    avtoSpasColors: AvtoSpasColorScheme,
    shapes: Shapes = MaterialTheme.shapes,
    typography: Typography = MaterialTheme.typography,
    content: @Composable () -> Unit
) {
    val rememberedColorScheme = remember { avtoSpasColors }
    CompositionLocalProvider(
        LocalAvtoSpasColorScheme provides rememberedColorScheme,
    ) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

/**
 * MaterialTheme wrapper with our colorScheme
 */
object AvtoSpasTheme {
    val colorScheme: AvtoSpasColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalAvtoSpasColorScheme.current


    val materialColors: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.shapes
}

internal val LocalAvtoSpasColorScheme = staticCompositionLocalOf { AvtoSpasColorScheme.Light }

