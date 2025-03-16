package ru.avtospas.feature.main.presentation

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SheetValue

import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.avtospas.core_ui.theme.AvtoSpasTheme
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import dev.icerock.moko.resources.ImageResource
import ru.avtospas.feature.login.MR

data class CustomRudioOption(
    val icon: ImageResource,
    val rait: String,
    val title: String,
    val price: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(

){
    var address by remember { mutableStateOf("") }
    var raiting by remember { mutableStateOf("") }
    var from by remember { mutableStateOf("")}
    var to by remember { mutableStateOf("")}

    var selectedOption by remember { mutableStateOf("") }
    val options = remember { mutableStateListOf(
        CustomRudioOption(MR.images.truck, "4,9", "Со здвижной платформой", "5000,00")
    ) }

    val sheetState = rememberStandardBottomSheetState(initialValue = SheetValue.PartiallyExpanded)
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 350.dp,
        modifier = Modifier
            .background(AvtoSpasTheme.colorScheme.whiteGray),
        sheetContent = {
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
                        Column(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (option.title == selectedOption) AvtoSpasTheme.colorScheme.whiteGray else AvtoSpasTheme.colorScheme.grayButton)
                                .clickable { selectedOption = option.title }
                                .padding(vertical = 12.dp, horizontal = 16.dp)
                        ) {

                            Text(
                                text = option.title,
                                color = AvtoSpasTheme.colorScheme.defBlackWhite,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
                Spacer(modifier = Modifier.height(700.dp))
                //Сюда делаем дальше
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.DarkGray)
        ) {
            if (sheetState.currentValue == SheetValue.PartiallyExpanded)
            Column {
                Spacer(modifier = Modifier.height(30.dp))
                Row (
                    modifier = Modifier
                        //.background(Color.Red)
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier
                        .width(290.dp)
                    ) {

                        BasicTextField(
                            value = address,
                            textStyle = TextStyle(
                                fontSize = 20.sp,
                                color = AvtoSpasTheme.colorScheme.defBlackWhite
                            ),
                            onValueChange = {newText -> address = newText},
                            singleLine = true,
                            modifier = Modifier
                                .height(50.dp)
                                .fillMaxWidth()
                                .background(AvtoSpasTheme.colorScheme.whiteGray, shape = RoundedCornerShape(14.dp))
                                .border(
                                    2.dp,
                                    AvtoSpasTheme.colorScheme.grayButtonBorder,
                                    RoundedCornerShape(14.dp)
                                ),


                            decorationBox = { innerTextField ->
                                Row{
                                    Column{
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(vertical = 10.dp)
                                        ) {
                                            Icon(
                                                imageVector =  Icons.Filled.Search,
                                                contentDescription = "Find",
                                                tint = AvtoSpasTheme.colorScheme.searchIconColor,
                                                modifier = Modifier
                                                    .size(55.dp)
                                                    .padding(5.dp)
                                            )
                                            Box(
                                                modifier = Modifier.weight(1f)
                                            ){
                                                if(address.isEmpty()){
                                                    Text(
                                                        text = "Найдем адрес тут?",
                                                        color = AvtoSpasTheme.colorScheme.grayButtonBorder
                                                    )
                                                }
                                                innerTextField()
                                            }
                                            Spacer(modifier = Modifier.width(10.dp))
                                        }
                                    }

                                }
                            }
                        )
                    }
                    Spacer(modifier = Modifier.width(7.dp)) // Отступ между полем и кругом

                    Box(
                        modifier = Modifier
                            .size(70.dp),
                            //.clip(CircleShape)
                            //.background(Color.Gray), // Цвет заглушки
                        contentAlignment = Alignment.TopEnd
                    ) {

                        Box(
                            modifier = Modifier
                                .size(70.dp)
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
                }
            }

        }
    }
}