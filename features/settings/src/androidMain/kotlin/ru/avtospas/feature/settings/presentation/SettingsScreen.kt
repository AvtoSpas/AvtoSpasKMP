package ru.avtospas.feature.settings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.AnimatedIosSwitch
import ru.avtospas.core_ui.theme.AvtoSpasTheme

@Composable
fun SettingsScreen(onNavigateToMainScreen: () -> Unit) {

    var darkTheme by remember { mutableStateOf(false) }
    var notifications by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, top = 60.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Box{
                IconButton(
                    onClick = onNavigateToMainScreen,
                    modifier = Modifier.size(45.dp)
                ) {
                    Icon(
                        Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "Кнопка назад",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row{
                        Text(
                            text = "Настройки",
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold,
                            color = AvtoSpasTheme.colorScheme.defBlackWhite
                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ){
            Spacer(modifier = Modifier.height(70.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Очистить кэш карты",
                    color = AvtoSpasTheme.colorScheme.defBlackWhite
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "Темная тема",
                    color = AvtoSpasTheme.colorScheme.defBlackWhite)
                Spacer(modifier = Modifier.width(150.dp))
                AnimatedIosSwitch(
                    checked = darkTheme,
                    onCheckedChange = { darkTheme = it }
                )
            }
        }
        Box(modifier = Modifier.padding(20.dp)) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp),
                color = AvtoSpasTheme.colorScheme.defBlackWhite,
                thickness = 1.dp
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ){
            Row{
                Text(
                    text = "Уведомления",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    color = AvtoSpasTheme.colorScheme.defBlackWhite
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "Включить все уведомления",
                    color = AvtoSpasTheme.colorScheme.defBlackWhite)
                Spacer(modifier = Modifier.width(28.dp))
                AnimatedIosSwitch(
                    checked = notifications,
                    onCheckedChange = { notifications = it }
                )
            }
        }
    }
}