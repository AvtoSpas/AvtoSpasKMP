package com.example.avtospaskmp.android.screens

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
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CodeScreen(phoneNumber:String,
               onNavigateToPhoneScreen: () -> Unit,
               onNavigateToFirstRegScreen:()->Unit){
    var code by remember { mutableStateOf("") }
    Column {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, top = 60.dp)
        )
        {
            IconButton (
                onClick = onNavigateToPhoneScreen,
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
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Код был отправлен на номер ${phoneNumber}",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )
                Column (
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(25.dp)
                ){
                    BasicTextField(
                        value = code,
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ),
                        onValueChange = {
                            if(it.length <= 7) {
                                code = formatCode(it)
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
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp)
                            ) {
                                if(code.isEmpty())
                                    Text(
                                        text = "___-___",
                                        color = Color(0xffE8E7E7)
                                    )
                                innerTextField() // Помещаем реальное поле ввода сюда
                            }
                        }
                    )
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 40.dp),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(3.dp, color = Color(0xffE53B19)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xffE53B19)),
                        onClick = onNavigateToFirstRegScreen
                    ) { Text(text="Далее",
                        fontSize = 16.sp) }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 40.dp),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(3.dp, color = Color(0xffE8E7E7)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xffffff)),
                        onClick = { }
                    ) { Text(text="Отправить код еще раз",
                        color = Color(0xffE53B19),
                        fontSize = 16.sp) }
                }
            }
        }
    }
}

fun formatCode(code: String): String {
    val cleanCode = code.replace("[^\\d]".toRegex(), "")
    val formatted = when {
        cleanCode.length <= 3 -> "${cleanCode}"
        cleanCode.length <= 7 -> "${cleanCode.take(3)}-${cleanCode.drop(3).take(3)}"
        else -> "${cleanCode.take(3)}-${cleanCode.drop(3).take(3)}"

    }
    return formatted
}