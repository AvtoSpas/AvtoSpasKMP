package ru.avtospas.android.screens

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.avtospas.android.ui.AvtoSpasTheme
@Composable
fun PhoneScreen(
    onNavigateToStartScreen: () -> Unit,
    onNavigateToCodeScreen: (String) -> Unit
) {
    var phoneNumber by remember { mutableStateOf(TextFieldValue("+7")) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, top = 60.dp)
        ) {
            IconButton(
                onClick = onNavigateToStartScreen,
                modifier = Modifier.size(45.dp)
            ) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Кнопка назад",
                    modifier = Modifier.fillMaxSize()
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
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Text(
                    text = "Введите номер телефона",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.fillMaxWidth()
                )
                BasicTextField(
                    value = phoneNumber,
                    onValueChange = { newValue ->
                        if (newValue.text.startsWith("+7")) {
                            val formatted = formatPhoneNumber(newValue)
                            phoneNumber = formatted
                        }
                    },
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        color = AvtoSpasTheme.colorScheme.defDarkWhite
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Phone
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
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp, horizontal = 20.dp)
                        ) {
                            if (phoneNumber.text.isEmpty())
                                Text(
                                    text = "+7 (000) 000-00-00",
                                    color = AvtoSpasTheme.colorScheme.grayButtonBorder
                                )
                            innerTextField() // Отображаем поле ввода
                        }
                    }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(47.dp)
                        .padding(horizontal = 30.dp),
                    shape = RoundedCornerShape(14.dp),
                    border = BorderStroke(3.dp, color = AvtoSpasTheme.colorScheme.orangeColor),
                    colors = ButtonDefaults.buttonColors(containerColor = AvtoSpasTheme.colorScheme.orangeColor),
                    onClick = { onNavigateToCodeScreen(phoneNumber.text) }
                ) {
                    Text(
                        text = "Далее",
                        color = AvtoSpasTheme.colorScheme.white,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }


}

fun formatPhoneNumber(newValue: TextFieldValue): TextFieldValue {
    val cleanInput = newValue.text
        .replace("[^\\d]".toRegex(), "")
        .replaceFirst("^7+".toRegex(), "")
        .take(10)

    val mask = "+7 (XXX) XXX-XX-XX"
    val formatted = buildString {
        append("+7")
        var index = 0
        for (char in mask.drop(2)) {
            if (index >= cleanInput.length) break
            when (char) {
                'X' -> {
                    append(cleanInput[index])
                    index++
                }

                else -> append(char)
            }
        }
    }

    val newCursorPosition = calculateNewCursorPosition(
        oldText = newValue.text,
        newText = formatted,
        oldCursorPosition = newValue.selection.start
    )

    return TextFieldValue(
        text = formatted,
        selection = TextRange(newCursorPosition)
    )
}

fun calculateNewCursorPosition(oldText: String, newText: String, oldCursorPosition: Int): Int {
    if (oldCursorPosition > oldText.length) return newText.length

    val beforeCursor = oldText.substring(0, oldCursorPosition)
    val nonDigitsBefore = beforeCursor.replace("[\\d]".toRegex(), "").length
    val digitsBefore = oldCursorPosition - nonDigitsBefore

    var newCursor = 0
    var digitsCount = 0
    for (i in newText.indices) {
        if (digitsCount >= digitsBefore) break
        if (newText[i].isDigit()) digitsCount++
        newCursor++
    }

    return newCursor.coerceAtMost(newText.length)
}