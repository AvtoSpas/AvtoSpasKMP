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
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.AvtoSpasLogo
import components.AvtoSpasRedButton
import components.AvtoSpasWhiteButton
import dev.icerock.moko.resources.compose.stringResource
import ru.avtospas.core_ui.theme.AvtoSpasTheme
import ru.avtospas.core_ui.transformations.OtpCodeVisualTransformation
import ru.avtospas.feature.login.MR

@Composable
fun CodeScreen(
    phoneNumber: String,
    otpCode: String,
    modifier: Modifier = Modifier,
    isContinueEnabled: Boolean,
    onCodeChange: (String) -> Unit,
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
                onClick = onContinueClick,
                modifier = Modifier.size(45.dp)
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowLeft,
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
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Text(
                    text = stringResource(MR.strings.code_was_sent_to, phoneNumber),
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
                        value = otpCode,
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            color = AvtoSpasTheme.colorScheme.defDarkWhite,
                            textAlign = TextAlign.Center
                        ),
                        visualTransformation = OtpCodeVisualTransformation(),
                        onValueChange = onCodeChange,
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
                                if (otpCode.isEmpty())
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
                        AvtoSpasRedButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(47.dp)
                                .padding(horizontal = 30.dp),
                            enabled = isContinueEnabled,
                            onClick = onBack
                        ) {
                            Text(
                                text = stringResource(MR.strings.next),
                                fontSize = 16.sp,
                                color = AvtoSpasTheme.colorScheme.white
                            )
                        }

                        AvtoSpasWhiteButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(47.dp)
                                .padding(horizontal = 30.dp),
                            onClick = { }
                        ) {
                            Text(
                                text = stringResource(MR.strings.send_code_again),
                                color = AvtoSpasTheme.colorScheme.defDarkWhite,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }

        BackHandler {
            onBack()
        }
    }
}