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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.AvtoSpasLogo
import components.AvtoSpasRedButton
import dev.icerock.moko.resources.compose.stringResource
import ru.avtospas.core_ui.theme.AvtoSpasTheme
import ru.avtospas.core_ui.transformations.RussianPhoneNumberVisualTransformation
import ru.avtospas.feature.login.MR

@Composable
fun PhoneScreen(
    phoneNumber: String,
    isContinueButtonEnabled: Boolean,
    onPhoneNumberChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onContinueClick: () -> Unit
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
                modifier = Modifier.size(45.dp)
            ) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Кнопка назад",
                    modifier = Modifier.fillMaxSize()
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
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Text(
                    text = stringResource(MR.strings.enter_phone_number),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.fillMaxWidth()
                )
                BasicTextField(
                    value = phoneNumber,
                    onValueChange = onPhoneNumberChange,
                    visualTransformation = RussianPhoneNumberVisualTransformation(),
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
                            if (phoneNumber.isEmpty())
                                Text(
                                    text = "+7 (000) 000-00-00",
                                    color = AvtoSpasTheme.colorScheme.grayButtonBorder
                                )
                            innerTextField() // Отображаем поле ввода
                        }
                    }
                )

                AvtoSpasRedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(47.dp)
                        .padding(horizontal = 30.dp),
                    enabled = isContinueButtonEnabled,
                    onClick = { onContinueClick() }
                ) {
                    Text(
                        text = stringResource(MR.strings.next),
                        color = AvtoSpasTheme.colorScheme.white,
                        fontSize = 16.sp
                    )
                }
            }
        }

        BackHandler {
            onBack()
        }
    }
}



