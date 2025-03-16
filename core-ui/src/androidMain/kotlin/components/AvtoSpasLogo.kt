package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ru.avtospas.core_ui.theme.AvtoSpasTheme

@Composable
fun AvtoSpasLogo(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Авто",
            textAlign = TextAlign.Center,
            color = AvtoSpasTheme.colorScheme.defBlackWhite,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold

        )

        Text(
            text = "Спас",
            textAlign = TextAlign.Center,
            color = AvtoSpasTheme.colorScheme.corporateOrangeColor,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    }
}