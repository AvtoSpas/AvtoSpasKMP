package components

import androidx.compose.ui.graphics.ImageBitmap

data class CustomRadioOption(
    val tag: String,
    val icon: ImageBitmap,
    val time: String,
    val title: String,
    val price: String
)