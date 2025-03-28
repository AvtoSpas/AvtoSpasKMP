package ru.avtospas.feature.main.presentation

import android.annotation.SuppressLint
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
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.location.LocationServices
import com.google.firebase.firestore.GeoPoint
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import components.AvtoSpasRedButton
import components.CreateOrderColumn
import dev.icerock.moko.resources.compose.stringResource
import ru.avtospas.feature.main.R
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.location.Location


@SuppressLint("MissingPermission", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(

){
    var address by remember { mutableStateOf("") }
    var raiting by remember { mutableStateOf("4,9") }

    var selfLocation by remember { mutableStateOf("Омск") }

    var surname by remember { mutableStateOf("Иванов") }
    var name by remember { mutableStateOf("Иван") }

    var zoom by remember { mutableStateOf(10f) }

    var userLocation by remember { mutableStateOf(Point(55.7558, 37.6173)) }

    val context = LocalContext.current
    lateinit var mapView: MapView

    val sheetState = rememberStandardBottomSheetState(initialValue = SheetValue.PartiallyExpanded)
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }

    MapKitFactory.setApiKey("fb01341c-367a-49b3-bfa0-7bcda8ac61bf")
    MapKitFactory.initialize(context)
    MapKitFactory.getInstance().onStart()


    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 380.dp,
        modifier = Modifier
            .background(AvtoSpasTheme.colorScheme.whiteGray),
        sheetContent = {
            if (sheetState.currentValue == SheetValue.PartiallyExpanded)
            CreateOrderColumn(
                MR.images.truck.drawableResId,
                MR.images.wallet.drawableResId,
                MR.images.sliders.drawableResId,
                MR.strings.order.resourceId
            )
            else
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
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.DarkGray)
        ) {
            Box(
            ) {
                AndroidView(
                    factory = { context ->
                        mapView = MapView(context)
                        mapView.map.move(
                            CameraPosition(Point(55.7558, 37.6173), zoom, 0f, 0f) // Пример с координатами Москвы
                        )
                        mapView
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
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
                    Spacer(modifier = Modifier.width(7.dp))

                    Box(
                        modifier = Modifier
                            .size(70.dp),
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
            Column {
                Spacer(modifier = Modifier.height(230.dp))
                Row{
                    Spacer(modifier = Modifier.weight(1f))
                    Column {
                        Button(
                            onClick = {
                                val currentPosition = mapView.map.cameraPosition
                                val newZoom = currentPosition.zoom + 1 // Увеличиваем на 1 уровень
                                val newPosition = CameraPosition(
                                    currentPosition.target, // Сохраняем текущие координаты
                                    newZoom,
                                    currentPosition.azimuth,
                                    currentPosition.tilt
                                )
                                mapView.map.move(newPosition)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = ""
                            )
                        }
                        Button(
                            onClick = {
                                val currentPosition = mapView.map.cameraPosition
                                val newZoom = currentPosition.zoom - 1 // Увеличиваем на 1 уровень
                                val newPosition = CameraPosition(
                                    currentPosition.target, // Сохраняем текущие координаты
                                    newZoom,
                                    currentPosition.azimuth,
                                    currentPosition.tilt
                                )
                                mapView.map.move(newPosition)
                            }
                        ) {
                            Icon(
                                painter = painterResource(MR.images.remove.drawableResId),
                                contentDescription = ""
                            )
                        }
                        Button(
                            onClick = {
                                fusedLocationClient.lastLocation.addOnSuccessListener { location: android.location.Location? ->
                                    if (location != null) {
                                        userLocation = Point(location.latitude, location.longitude)
                                        mapView.map.move(
                                            CameraPosition(userLocation, 17f, 0f, 0f),
                                            Animation(Animation.Type.SMOOTH, 1f),
                                            null
                                        )
                                    }
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(MR.images.depth.drawableResId),
                                contentDescription = ""
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }
    }
}