package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.avtospas.core_ui.theme.AvtoSpasTheme

@Composable
fun OrderColumn(
    raiting: String,
    selectedOption: MutableState<CustomRadioOption?>,
    orderData: MutableState<OrderData>,
    chatIconId: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Через " + selectedOption.value?.time.toString() + " приедет",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = AvtoSpasTheme.colorScheme.defBlackWhite
        )
        Row{
            Text(
                text = orderData.value.carColor + " " + orderData.value.carModel + " ",
                fontSize = 18.sp,
                color = AvtoSpasTheme.colorScheme.defBlackWhite
            )
            Row(
                modifier = Modifier
                    .background(AvtoSpasTheme.colorScheme.lightGray)
            ) {
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = orderData.value.carNumber,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = AvtoSpasTheme.colorScheme.black
                )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(

        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier
                        .size(80.dp),
                    contentAlignment = Alignment.TopEnd
                ) {

                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(Color.Gray)

                    ){

                    }
                    Row {
                        Spacer(modifier = Modifier.weight(1f))
                        Column (
                            verticalArrangement = Arrangement.Top,
                            modifier = Modifier.offset(0.dp)
                                .clip(RoundedCornerShape(8.dp))
                        ){
                            Row (
                                modifier = Modifier
                                    .background(AvtoSpasTheme.colorScheme.whiteGray)
                                    .width(30.dp)
                                    .offset(0.dp)
                                    .padding(5.dp, 0.dp),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Column (modifier = Modifier
                                    .padding(0.dp)
                                    .offset(0.dp)
                                    .wrapContentHeight()
                                    //.background(Color.Red)
                                ) {
                                    Text(
                                        text = raiting,
                                        color = AvtoSpasTheme.colorScheme.defBlackWhite,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(vertical = 0.dp)
                                    )
                                }
                            }
                        }
                    }
                }
                Text(
                    text = orderData.value.driverName,
                    fontSize = 16.sp,
                    color = AvtoSpasTheme.colorScheme.defBlackWhite
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button(onClick = {},
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    colors = ButtonDefaults.buttonColors(containerColor = AvtoSpasTheme.colorScheme.grayButtonBorder)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Phone,
                        contentDescription = "",
                        tint = AvtoSpasTheme.colorScheme.green,
                        modifier = Modifier
                            .size(50.dp)
                    )
                }
                Text(
                    text = "Звонок",
                    fontSize = 16.sp,
                    color = AvtoSpasTheme.colorScheme.defBlackWhite
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button(onClick = {},
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    colors = ButtonDefaults.buttonColors(containerColor = AvtoSpasTheme.colorScheme.grayButtonBorder)
                ) {
                    Icon(
                        painter = painterResource(chatIconId),
                        contentDescription = "",
                        tint = AvtoSpasTheme.colorScheme.defBlackWhite,
                        modifier = Modifier
                            .size(50.dp)
                    )
                }
                Text(
                    text = "Чат",
                    fontSize = 16.sp,
                    color = AvtoSpasTheme.colorScheme.defBlackWhite
                )
            }
        }
    }
}