package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.avtospas.core_ui.theme.AvtoSpasTheme

data class CustomRudioOption(
    val tag: String,
    val icon: ImageBitmap,
    val time: String,
    val title: String,
    val price: String
)



@Composable
fun CreateOrderColumn(
    imageId: Int,
    walletImageId : Int,
    settingsImageId : Int,
    orderStringId : Int
){
    var from by remember { mutableStateOf("") }
    var to by remember { mutableStateOf("") }

    val flag : Boolean

    //Temp

    var selectedOption by remember { mutableStateOf("") }
    val options = remember { mutableStateListOf(
        CustomRudioOption("1", ImageBitmap(1, 1), "8 минут", "Со сдвижной платформой", "5000,00"),
        CustomRudioOption("2", ImageBitmap(1, 1), "10 минут", "Со сдвижной платформой", "7000,00"),
        CustomRudioOption("3", ImageBitmap(1, 1), "12 минут", "Со сдвижной платформой", "8000,00"),
        CustomRudioOption("4", ImageBitmap(1, 1), "13 минут", "Со сдвижной платформой", "10000,00"),
        CustomRudioOption("5", ImageBitmap(1, 1), "15 минут", "Со сдвижной платформой", "12000,00"),
        CustomRudioOption("6", ImageBitmap(1, 1), "17 минут", "Со сдвижной платформой", "15000,00"),
    ) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Row{
            BasicTextField(
                value = from,
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    color = AvtoSpasTheme.colorScheme.defBlackWhite
                ),
                onValueChange = {newText -> from = newText},
                singleLine = true,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),

                decorationBox = { innerTextField ->
                    Row{
                        Column{
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.LocationOn,
                                    contentDescription = "Marker Pin",
                                    tint = AvtoSpasTheme.colorScheme.defBlackWhite,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Box(
                                    modifier = Modifier.weight(1f)
                                ){
                                    if(from.isEmpty()){
                                        Text(
                                            text = "Откуда едем?",
                                            color = AvtoSpasTheme.colorScheme.defBlackWhite
                                        )
                                    }
                                    innerTextField()
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(AvtoSpasTheme.colorScheme.defBlackWhite)
                                        .align(Alignment.BottomCenter)
                                    )
                                }
                                Spacer(modifier = Modifier.width(55.dp))
                            }
                        }

                    }
                }
            )
        }
        Row{
            BasicTextField(
                value = to,
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    color = AvtoSpasTheme.colorScheme.defBlackWhite
                ),
                onValueChange = {newText -> to = newText},
                singleLine = true,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),

                decorationBox = { innerTextField ->
                    Row{
                        Column{
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.LocationOn,
                                    contentDescription = "Marker Pin",
                                    tint = AvtoSpasTheme.colorScheme.defBlackWhite,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Box(
                                    modifier = Modifier.weight(1f)
                                ){
                                    if(to.isEmpty()){
                                        Text(
                                            text = "Куда едем?",
                                            color = AvtoSpasTheme.colorScheme.defBlackWhite
                                        )
                                    }
                                    innerTextField()
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(AvtoSpasTheme.colorScheme.defBlackWhite)
                                        .align(Alignment.BottomCenter)
                                    )
                                }
                                Spacer(modifier = Modifier.width(55.dp))
                            }
                        }
                    }

                }
            )
        }
        LazyRow {
            items(options) { option ->
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (option.tag == selectedOption) AvtoSpasTheme.colorScheme.lightGray else AvtoSpasTheme.colorScheme.whiteGray)
                        .clickable { selectedOption = option.tag }
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                        .width(80.dp)
                        .testTag(option.tag),
                    //horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column {
                        Box(){
                            Image(
                                painter = painterResource(id = imageId),
                                contentDescription = ""
                            )
                            Column (
                                //verticalArrangement = Arrangement.Bottom,
                                modifier = Modifier.offset(0.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            ){
                                Spacer(modifier = Modifier.height(60.dp))
                                Row (
                                    modifier = Modifier
                                        .background(AvtoSpasTheme.colorScheme.whiteGray)
                                        .offset(0.dp)
                                        .padding(5.dp, 0.dp),
                                    horizontalArrangement = Arrangement.Center
                                ){
                                    Column (modifier = Modifier
                                        .padding(0.dp)
                                        .offset(0.dp)
                                        //.background(Color.Red)
                                    ) {
                                        Text(
                                            text = option.time,
                                            color = AvtoSpasTheme.colorScheme.defBlackWhite,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            lineHeight = 11.sp
                                        )
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = option.title,
                            color = AvtoSpasTheme.colorScheme.defBlackWhite,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 11.sp
                        )
                        Text(
                            text = option.price,
                            color = AvtoSpasTheme.colorScheme.defBlackWhite,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 11.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row{
            IconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(id = walletImageId),
                    contentDescription = ""
                )
            }
            AvtoSpasRedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .padding(horizontal = 30.dp)
                    .weight(1f),
                //enabled = ,
                onClick = { }
            ) {
                Text(
                    text = stringResource(id = orderStringId),
                    color = AvtoSpasTheme.colorScheme.white,
                    fontSize = 16.sp
                )
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(id = settingsImageId),
                    contentDescription = ""
                )
            }
        }
        Spacer(modifier = Modifier.height(400.dp))
        //Сюда делаем дальше
    }
}