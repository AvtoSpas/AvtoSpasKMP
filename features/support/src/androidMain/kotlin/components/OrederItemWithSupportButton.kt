package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.avtospas.core_ui.theme.AvtoSpasTheme

@Composable
fun OrderItemWithSupportButton(
    id: String,
    orderType: String,
    time: String,
    price: String,
    address: String,
    imageId: Int
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(AvtoSpasTheme.colorScheme.grayButtonBorder)
    ) {
        Row(
            modifier = Modifier.padding(5.dp)
        ){
            Row{
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = orderType + ", в " + time,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = AvtoSpasTheme.colorScheme.defBlackWhite
                    )
                    Text(text = price + "₽, " + address,
                        color = AvtoSpasTheme.colorScheme.defBlackWhite)
                    Text(
                        text = "Помощь",
                        color = AvtoSpasTheme.colorScheme.defBlackWhite,
                        lineHeight = 5.sp,
                        modifier = Modifier.padding(0.dp)
                            .clickable{}
                    )
                }
                Column(
                ) {
                    Image(
                        painter = painterResource(id = imageId),
                        contentDescription = "",
                        modifier = Modifier.size(55.dp)
                    )
                }
            }

        }

    }


}