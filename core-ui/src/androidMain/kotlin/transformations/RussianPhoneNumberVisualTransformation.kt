package ru.avtospas.core_ui.transformations

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class RussianPhoneNumberVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.text.length >= 10) text.text.substring(0, 10) else text.text

        if (trimmed.isEmpty()) {
            val prefix = "+7 "
            return TransformedText(
                AnnotatedString(prefix),
                object : OffsetMapping {
                    override fun originalToTransformed(offset: Int): Int = prefix.length
                    override fun transformedToOriginal(offset: Int): Int = 0
                }
            )
        }

        val builder = StringBuilder()
        builder.append("+7 (")
        for (i in trimmed.indices) {
            builder.append(trimmed[i])
            if (i == 2) builder.append(") ")
            if (i == 5) builder.append("-")
            if (i == 7) builder.append("-")
        }
        val out = builder.toString()

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                var result = 4 + offset
                if (offset > 2) result += 2
                if (offset > 5) result += 1
                if (offset > 7) result += 1
                return result.coerceAtMost(out.length)
            }

            override fun transformedToOriginal(offset: Int): Int {
                var original = offset - 4
                if (offset >= 8) original -= 2
                if (offset >= 11) original -= 1
                if (offset >= 14) original -= 1
                return original.coerceAtLeast(0)
            }
        }
        return TransformedText(AnnotatedString(out), offsetMapping)
    }
}