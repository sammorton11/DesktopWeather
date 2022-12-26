package screens.weather_screen.components.current_weather

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CurrentWeatherHeading() {

    Text(
        text = "Current Weather",
        modifier = Modifier.padding(start = 16.dp, top = 25.dp, bottom = 25.dp),
        color = Color.White,
        style = MaterialTheme.typography.h6,
    )
}