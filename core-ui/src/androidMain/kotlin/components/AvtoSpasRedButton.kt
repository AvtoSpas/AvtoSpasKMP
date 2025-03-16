package components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.avtospas.core_ui.theme.AvtoSpasTheme

@Composable
fun AvtoSpasRedButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(3.dp, color = AvtoSpasTheme.colorScheme.corporateOrangeColor),
        colors = ButtonDefaults.buttonColors(containerColor = AvtoSpasTheme.colorScheme.corporateOrangeColor),
        onClick = onClick,
        content = content,
    )
}