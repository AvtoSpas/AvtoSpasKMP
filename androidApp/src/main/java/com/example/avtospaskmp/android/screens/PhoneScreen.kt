package com.example.avtospaskmp.android.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun PhoneScreen(onNavigateToStartScreen: ()-> Unit, onNavigateToCodeScreen: (String)-> Unit) {
    var phoneNumber by remember { mutableStateOf("+7") }
    Column {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, top = 60.dp)
        )
        {
            IconButton (
                onClick = onNavigateToStartScreen,
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
                color = Color.Black,
                fontSize = 40.sp,
                modifier = Modifier
                    .padding(0.dp),
                fontWeight = FontWeight.Bold

            )

            Text(
                text = "Спас",
                textAlign = TextAlign.Center,
                color = Color(0xffE53B19),
                fontSize = 40.sp,
                modifier = Modifier
                    .padding(0.dp),
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 170.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Text(
                    text = "Введите номер телефона",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )
                BasicTextField(
                    value = phoneNumber,
                    textStyle = TextStyle(
                        fontSize = 20.sp
                    ),
                    onValueChange = {
                        if(it.length <= 18) {
                            phoneNumber = formatPhoneNumber(it)
                        }

                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Phone
                    ),

                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp)
                        .border(2.dp, Color(0xffE8E7E7), RoundedCornerShape(12.dp)),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp, horizontal = 20.dp)
                        ) {
                            innerTextField() // Помещаем реальное поле ввода сюда
                        }
                    }

                    //ToDo поправить курсор при вводе номера телефона
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(horizontal = 40.dp),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(3.dp, color = Color(0xffE53B19)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xffE53B19)),
                    onClick = { onNavigateToCodeScreen(phoneNumber) }
                ) { Text(text="Далее",
                    fontSize = 16.sp) }
            }
        }
    }


}
fun formatPhoneNumber(number: String): String {
    // Форматируем строку как +7 (XXX) XXX-XXXX
    val cleanNumber = number.replace("[^\\d]".toRegex(), "") // Убираем все нецифровые символы
    val formatted = when {
        cleanNumber.length <= 1 -> "+7" // Префикс +7
        cleanNumber.length <= 4 -> "+7 (${cleanNumber.drop(1)})" // (XXX)
        cleanNumber.length <= 7 -> "+7 (${cleanNumber.drop(1).take(3)}) ${cleanNumber.drop(4).take(3)}"
        cleanNumber.length <= 9 -> "+7 (${cleanNumber.drop(1).take(3)}) ${cleanNumber.drop(4).take(3)}-${cleanNumber.drop(5).take(2)}"// (XXX) XXX
        cleanNumber.length <= 11 -> "+7 (${cleanNumber.drop(1).take(3)}) ${cleanNumber.drop(4).take(3)}-${cleanNumber.drop(7).take(2)}-${cleanNumber.drop(9).take(2)}"// (XXX) XXX-XXXX
        else -> "+7 (${cleanNumber.drop(1).take(3)}) ${cleanNumber.drop(4).take(3)}-${cleanNumber.drop(7).take(4)}" // Максимум 12 символов
    }
    return formatted
}