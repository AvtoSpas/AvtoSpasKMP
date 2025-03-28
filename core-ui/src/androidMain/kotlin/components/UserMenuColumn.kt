package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.avtospas.core_ui.theme.AvtoSpasTheme

@Composable
fun UserMenuColumn(
    name: String,
    surname: String,
    raiting: String,
    selfLocation: String
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Row {
            Box(
                modifier = Modifier
                    .size(75.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)

            ){

            }
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = name,
                    fontSize = 20.sp,
                    lineHeight = 16.sp
                )
                Text(
                    text = surname,
                    fontSize = 20.sp,
                    lineHeight = 16.sp
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = AvtoSpasTheme.colorScheme.grayButtonBorder),
                    shape = RoundedCornerShape(5.dp),
                    contentPadding = PaddingValues(5.dp)

                ) {
                    Text(
                        text = "РЕДАКТИРОВАТЬ ПРОФИЛЬ",
                        modifier = Modifier
                            .padding(0.dp),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 1.sp,
                        color = AvtoSpasTheme.colorScheme.defBlackWhite
                    )
                }
            }
            Spacer(modifier = Modifier.width(30.dp))
            Column {
                Row{
                    Text(
                        text="Рейтинг ",
                        color =  AvtoSpasTheme.colorScheme.darkLightGray,
                        fontSize = 17.sp
                    )
                    Text(
                        text = raiting,
                        color = AvtoSpasTheme.colorScheme.defBlackWhite,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Мое местоположение",
            color = AvtoSpasTheme.colorScheme.darkLightGray
        )
        Text(
            text = selfLocation,
            color = AvtoSpasTheme.colorScheme.defBlackWhite
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(5.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "История заказов",
                color = AvtoSpasTheme.colorScheme.defBlackWhite
            )
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(5.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "Способ оплаты",
                color = AvtoSpasTheme.colorScheme.defBlackWhite
            )
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(5.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "Служба поддержки",
                color = AvtoSpasTheme.colorScheme.defBlackWhite
            )
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(5.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "Безопасность",
                color = AvtoSpasTheme.colorScheme.defBlackWhite
            )
        }
        Spacer(modifier = Modifier.height(400.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(5.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.ExitToApp,
                    contentDescription = "",
                    tint = AvtoSpasTheme.colorScheme.defBlackWhite
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Выйти из аккаунта",
                    color = AvtoSpasTheme.colorScheme.defBlackWhite
                )
            }
        }
    }
}