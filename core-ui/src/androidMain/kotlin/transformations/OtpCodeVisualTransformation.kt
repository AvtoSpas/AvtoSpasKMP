package ru.avtospas.core_ui.transformations

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class OtpCodeVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.text.length > 6) text.text.substring(0, 6) else text.text
        var out = ""
        for (i in trimmed.indices) {
            out += trimmed[i]
            if (i == 2) out += '-'
        }

        return TransformedText(AnnotatedString(out), offsetMapping)
    }

    private val offsetMapping = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return when {
                offset < 3 -> offset
                else -> offset + 1
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            return when {
                offset <= 3 -> offset
                else -> offset - 1
            }
        }
    }
}
