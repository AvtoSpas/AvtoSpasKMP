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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.avtospas.android.ui.AvtoSpasTheme

@Composable
fun FirstRegScreen(
    onNavigateToCodeScreen: () -> Unit
) {
    var surname by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, top = 60.dp)
        ) {
            IconButton(
                onClick = onNavigateToCodeScreen,
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
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Введите данные о себе",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.fillMaxWidth()
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        BasicTextField(
                            value = surname,
                            textStyle = TextStyle(
                                fontSize = 20.sp,
                                color = AvtoSpasTheme.colorScheme.defDarkWhite,
                                textAlign = TextAlign.Center
                            ),
                            onValueChange = {
                                surname = it
                            },

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
                                    if (surname.isEmpty())
                                        Text(
                                            text = "Иван",
                                            color = AvtoSpasTheme.colorScheme.grayButtonBorder
                                        )
                                    innerTextField() // Помещаем реальное поле ввода сюда
                                }
                            }
                        )
                        BasicTextField(
                            value = name,
                            textStyle = TextStyle(
                                fontSize = 20.sp,
                                color = AvtoSpasTheme.colorScheme.defDarkWhite,
                                textAlign = TextAlign.Center
                            ),
                            onValueChange = {
                                name = it
                            },

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
                                    if (name.isEmpty())
                                        Text(
                                            text = "Иванов",
                                            color = AvtoSpasTheme.colorScheme.grayButtonBorder
                                        )
                                    innerTextField() // Помещаем реальное поле ввода сюда
                                }
                            }
                        )
                    }

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(47.dp)
                            .padding(horizontal = 30.dp),
                        shape = RoundedCornerShape(14.dp),
                        border = BorderStroke(3.dp, color = AvtoSpasTheme.colorScheme.orangeColor),
                        colors = ButtonDefaults.buttonColors(containerColor = AvtoSpasTheme.colorScheme.orangeColor),
                        onClick = { }
                    ) {
                        Text(
                            text = "Завершить регистрацию",
                            color = AvtoSpasTheme.colorScheme.white,
                            fontSize = 16.sp
                        )
                    }

                }
            }
        }
    }
}