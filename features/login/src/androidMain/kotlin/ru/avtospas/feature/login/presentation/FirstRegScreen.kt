package ru.avtospas.feature.login.presentation

import androidx.activity.compose.BackHandler
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.AvtoSpasLogo
import components.AvtoSpasRedButton
import dev.icerock.moko.resources.compose.stringResource
import ru.avtospas.core_ui.theme.AvtoSpasTheme
import ru.avtospas.feature.login.MR

@Composable
fun FirstRegScreen(
    name: String,
    surname: String,
    onNameChange: (String) -> Unit,
    onSurnameChange: (String) -> Unit,
    isContinueAvailable: Boolean,
    modifier: Modifier = Modifier,
    onContinueClick: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, top = 60.dp)
        ) {
            IconButton(
                onClick = onBack,
                Modifier.size(45.dp)
            ) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Кнопка назад",
                    Modifier.fillMaxSize()
                )
            }
        }

        AvtoSpasLogo(
            modifier = Modifier
                .fillMaxWidth()
                .padding(60.dp, 15.dp),
        )

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
                    text = stringResource(MR.strings.enter_personal_information),
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
                                color = AvtoSpasTheme.colorScheme.defBlackWhite,
                                textAlign = TextAlign.Center
                            ),
                            onValueChange = onSurnameChange,

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
                                color = AvtoSpasTheme.colorScheme.defBlackWhite,
                                textAlign = TextAlign.Center
                            ),
                            onValueChange = onNameChange,

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

                    AvtoSpasRedButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(47.dp)
                            .padding(horizontal = 30.dp),
                        enabled = isContinueAvailable,
                        onClick = { onContinueClick()}
                    ) {
                        Text(
                            text = stringResource(MR.strings.finish_registration),
                            color = AvtoSpasTheme.colorScheme.white,
                            fontSize = 16.sp
                        )
                    }

                }
            }
        }

        BackHandler {
            onBack()
        }
    }
}