package ru.avtospas.feature.login.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.resources.compose.painterResource
import ru.avtospas.core_ui.theme.AvtoSpasTheme
import ru.avtospas.feature.login.MR

@Composable
fun StartScreen(
    onNavigateToPhoneScreen: () -> Unit
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
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(horizontal = 40.dp),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(3.dp, color = AvtoSpasTheme.colorScheme.orangeColor),
                    colors = ButtonDefaults.buttonColors(containerColor = AvtoSpasTheme.colorScheme.orangeColor),
                    onClick = onNavigateToPhoneScreen
                ) {
                    Text(
                        text = "Регистрация",
                        fontSize = 16.sp,
                        color = AvtoSpasTheme.colorScheme.white
                    )
                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(horizontal = 40.dp),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(3.dp, color = AvtoSpasTheme.colorScheme.grayButtonBorder),
                    colors = ButtonDefaults.buttonColors(containerColor = AvtoSpasTheme.colorScheme.grayButton),
                    onClick = { }
                ) {
                    Text(
                        text = "Вход",
                        color = AvtoSpasTheme.colorScheme.defOrangeWhite,
                        fontSize = 16.sp
                    )
                }

            }
        }
    }


}