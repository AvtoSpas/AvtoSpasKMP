package ru.avtospas.feature.orders.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import classes.DayOfOrders
import classes.Order
import components.OrderItem
import ru.avtospas.core_ui.theme.AvtoSpasTheme
import ru.avtospas.feature.login.MR

@Composable
fun OrderScreen(onNavigateToMainScreen: () -> Unit) {

    val orders = remember { mutableStateListOf(
        DayOfOrders(
            date = "14.03.2025",
            dayOfTheWeek = "четверг",
            orders = listOf(
                Order(
                    "5", "Эвакуация", "20:03", "2500,00", " улица Чайковского, 40"
                ),
                Order(
                    "4", "Эвакуация", "16:13", "2500,00", " улица Чайковского, 11"
                ),
                Order(
                    "3", "Эвакуация", "15:03", "2500,00", " улица Чайковского, 12"
                ),

                )
        ),
        DayOfOrders(
            date = "14.03.2025",
            dayOfTheWeek = "четверг",
            orders = listOf(
                Order(
                    "5", "Эвакуация", "20:03", "2500,00", " улица Чайковского, 40"
                ),
                Order(
                    "4", "Эвакуация", "16:13", "2500,00", " улица Чайковского, 11"
                ),
                Order(
                    "3", "Эвакуация", "15:03", "2500,00", " улица Чайковского, 12"
                ),

                )
        ),
        DayOfOrders(
            date = "14.03.2025",
            dayOfTheWeek = "четверг",
            orders = listOf(
                Order(
                    "5", "Эвакуация", "20:03", "2500,00", " улица Чайковского, 40"
                ),
                Order(
                    "4", "Эвакуация", "16:13", "2500,00", " улица Чайковского, 11"
                ),
                Order(
                    "3", "Эвакуация", "15:03", "2500,00", " улица Чайковского, 12"
                ),

                )
        ),
        DayOfOrders(
            date = "14.03.2025",
            dayOfTheWeek = "четверг",
            orders = listOf(
                Order(
                    "5", "Эвакуация", "20:03", "2500,00", " улица Чайковского, 40"
                ),
                Order(
                    "4", "Эвакуация", "16:13", "2500,00", " улица Чайковского, 11"
                ),
                Order(
                    "3", "Эвакуация", "15:03", "2500,00", " улица Чайковского, 12"
                ),

            )
        ),
        DayOfOrders(
            date = "13.03.2025",
            dayOfTheWeek = "четверг",
            orders = listOf(
                Order(
                    "2", "Эвакуация", "12:13", "2500,00", " улица Чайковского, 10"
                ),
                Order(
                    "1", "Эвакуация", "12:03", "2500,00", " улица Чайковского, 10"
                ),
            )
        ),

    )}

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
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
                            text = "Мои",
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold,
                            color = AvtoSpasTheme.colorScheme.defBlackWhite
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Заказы",
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold,
                            color = AvtoSpasTheme.colorScheme.corporateOrangeColor
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, top = 30.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Column(

            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    items(orders){
                        option->
                        Text(text = option.date + ", " + option.dayOfTheWeek,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            color = AvtoSpasTheme.colorScheme.darkLightGray
                        )
                        Column {
                            option.orders.forEach{
                                order ->
                                Spacer(modifier = Modifier.height(10.dp))
                                OrderItem(
                                    order.orderType,
                                    order.time,
                                    order.price,
                                    order.address,
                                    MR.images.truck.drawableResId)
                            }
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                }
            }
        }
    }
}

