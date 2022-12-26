package screens.weather_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun WeatherIcon(imageState: ImageBitmap?, minWidth: Dp, minHeight: Dp){
    //Icon
    imageState?.let { bitmap ->
        Image(
            bitmap = bitmap,
            contentDescription = null,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth, minHeight = minHeight)
        )
    }
}