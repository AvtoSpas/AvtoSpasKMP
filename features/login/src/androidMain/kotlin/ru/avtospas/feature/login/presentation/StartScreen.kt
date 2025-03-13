package ru.avtospas.feature.login.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.AvtoSpasRedButton
import components.AvtoSpasWhiteButton
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import ru.avtospas.core_ui.theme.AvtoSpasTheme
import ru.avtospas.feature.login.MR

@Composable
fun StartScreen(
    onNavigateToPhoneScreen: () -> Unit,
    onNavigateToMainScreen: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(60.dp, 100.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Авто",
                textAlign = TextAlign.Center,
                color = AvtoSpasTheme.colorScheme.defDarkWhite,
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold

            )

            Text(
                text = "Спас",
                textAlign = TextAlign.Center,
                color = AvtoSpasTheme.colorScheme.orangeColor,
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Image(
            painter = painterResource(MR.images.truck),
            contentDescription = "Orange Truck",
            alignment = Alignment.CenterEnd,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 30.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                AvtoSpasRedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(horizontal = 40.dp),
                    onClick = onNavigateToPhoneScreen
                ) {
                    Text(
                        text = stringResource(MR.strings.registration),
                        fontSize = 16.sp,
                        color = AvtoSpasTheme.colorScheme.white
                    )
                }

                AvtoSpasWhiteButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(horizontal = 40.dp),
                    onClick = onNavigateToMainScreen
                ) {
                    Text(
                        text = stringResource(MR.strings.sign_in),
                        color = AvtoSpasTheme.colorScheme.defOrangeWhite,
                        fontSize = 16.sp
                    )
                }

            }
        }
    }


}