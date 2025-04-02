package ru.avtospas.feature.edit_profile.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.AvtoSpasRedButton
import ru.avtospas.core_ui.theme.AvtoSpasTheme

@Composable
fun EditProfileScreen(onNavigateToMainScreen: () -> Unit) {

    var surname by remember { mutableStateOf("Иванов") }
    var name by remember { mutableStateOf("Иван") }

    Column(
        modifier = Modifier
            .fillMaxSize()
    )  {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Редактирование",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = AvtoSpasTheme.colorScheme.defBlackWhite
            )
            Text(
                text = "Профиля",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = AvtoSpasTheme.colorScheme.corporateOrangeColor
            )
        }
        Spacer(modifier = Modifier.height(150.dp))
        Column(
            modifier = Modifier
                .padding(horizontal = 40.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center
            ){
                Box(
                    modifier = Modifier
                        .size(75.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)

                ){

                }
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Row {
                        Text(
                            text = name,
                            fontSize = 20.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = surname,
                            fontSize = 20.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = AvtoSpasTheme.colorScheme.grayButtonBorder),
                        shape = RoundedCornerShape(5.dp),
                        contentPadding = PaddingValues(5.dp)

                    ) {
                        Text(
                            text = "ЗАГРУЗИТЬ ИЗОБРАЖЕНИЕ",
                            modifier = Modifier
                                .padding(0.dp),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 1.sp,
                            color = AvtoSpasTheme.colorScheme.defBlackWhite
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Text(
                text = "Имя и фамилия"
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            BasicTextField(
                value = name,
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    color = AvtoSpasTheme.colorScheme.defBlackWhite,
                    //textAlign = TextAlign.Left
                ),
                onValueChange = {name = it},

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
                        //contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 20.dp)
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
            BasicTextField(
                value = surname,
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    color = AvtoSpasTheme.colorScheme.defBlackWhite,
                    //textAlign = TextAlign.Center
                ),
                onValueChange = { surname = it },

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
                        //contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 20.dp)
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

        }
        Spacer(modifier = Modifier.height(300.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            AvtoSpasRedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(47.dp)
                    .padding(horizontal = 30.dp),
                onClick = onNavigateToMainScreen
            ) {
                Text(
                    text = "Сохранить изменения",
                    color = AvtoSpasTheme.colorScheme.white,
                    fontSize = 16.sp
                )
            }
        }
    }
}