package com.example.avtospaskmp.android.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avtospaskmp.android.ui.AvtoSpasTheme

@Composable
fun CodeScreen(
    phoneNumber: String,
    onNavigateToPhoneScreen: () -> Unit,
    onNavigateToFirstRegScreen: () -> Unit
) {
    var code by remember { mutableStateOf(TextFieldValue("")) }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, top = 60.dp)
        ) {
            IconButton(
                onClick = onNavigateToPhoneScreen,
                Modifier.size(45.dp)
            ) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Кнопка назад",
                    Modifier.fillMaxSize()
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(60.dp, 15.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Авто",
                textAlign = TextAlign.Center,
                color = AvtoSpasTheme.colorScheme.defDarkWhite,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Спас",
                textAlign = TextAlign.Center,
                color = AvtoSpasTheme.colorScheme.orangeColor,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 170.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Text(
                    text = "Код был отправлен на номер ${phoneNumber}",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.fillMaxWidth()
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(40.dp)
                ) {
                    BasicTextField(
                        value = code,
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            color = AvtoSpasTheme.colorScheme.defDarkWhite,
                            textAlign = TextAlign.Center
                        ),
                        onValueChange = { newValue ->
                            if (newValue.text.length <= 7) {
                                val formatted = formatCode(newValue)
                                code = formatted
                            }
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp)
                            .border(
                                2.dp,
                                AvtoSpasTheme.colorScheme.grayButtonBorder,
                                RoundedCornerShape(14.dp)
                            ),
                        decorationBox = { innerTextField ->
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp)
                            ) {
                                if (code.text.isEmpty())
                                    Text(
                                        text = "___-___",
                                        color = AvtoSpasTheme.colorScheme.grayButtonBorder
                                    )
                                innerTextField()
                            }
                        }
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(47.dp)
                                .padding(horizontal = 30.dp),
                            shape = RoundedCornerShape(14.dp),
                            border = BorderStroke(
                                3.dp,
                                color = AvtoSpasTheme.colorScheme.orangeColor
                            ),
                            colors = ButtonDefaults.buttonColors(containerColor = AvtoSpasTheme.colorScheme.orangeColor),
                            onClick = onNavigateToFirstRegScreen
                        ) {
                            Text(
                                text = "Далее",
                                fontSize = 16.sp,
                                color = AvtoSpasTheme.colorScheme.white
                            )
                        }
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(47.dp)
                                .padding(horizontal = 30.dp),
                            shape = RoundedCornerShape(14.dp),
                            border = BorderStroke(
                                3.dp,
                                color = AvtoSpasTheme.colorScheme.grayButtonBorder
                            ),
                            colors = ButtonDefaults.buttonColors(containerColor = AvtoSpasTheme.colorScheme.grayButton),
                            onClick = { }
                        ) {
                            Text(
                                text = "Отправить код еще раз",
                                color = AvtoSpasTheme.colorScheme.defDarkWhite,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

fun formatCode(newValue: TextFieldValue): TextFieldValue {
    val cleanCode = newValue.text.replace("[^\\d]".toRegex(), "")
    val formatted = buildString {
        for (i in cleanCode.indices) {
            if (i == 3) append("-")
            append(cleanCode[i])
        }
    }.take(7)

    val newCursorPosition = calculateCodeCursorPosition(
        oldText = newValue.text,
        newText = formatted,
        oldCursorPosition = newValue.selection.start
    )

    return TextFieldValue(
        text = formatted,
        selection = TextRange(newCursorPosition)
    )
}

fun calculateCodeCursorPosition(oldText: String, newText: String, oldCursorPosition: Int): Int {
    if (oldCursorPosition > oldText.length) return newText.length

    val isAdding = newText.length > oldText.length
    val wasDashAdded = newText.count { it == '-' } > oldText.count { it == '-' }

    return when {
        isAdding && wasDashAdded -> oldCursorPosition + 1
        !isAdding && wasDashAdded -> oldCursorPosition - 1
        else -> oldCursorPosition
    }.coerceIn(0, newText.length)
}