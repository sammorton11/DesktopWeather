package screens.weather_screen.components.forecast_weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import data.WeatherCard
import screens.weather_screen.components.WeatherIcon
import utility.Constants
import utility.ImageDownloader

@Composable
fun ForecastCard(weatherCard: WeatherCard) {

    var imageState by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(weatherCard.iconUrl) {
        imageState = ImageDownloader.downloadImage(weatherCard.iconUrl)
    }

    Card(
        modifier = Modifier.padding(all = 4.dp),
        backgroundColor = Color.LightGray,
        elevation = Constants.card_elevation
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
//            imageState?.let { bitmap ->
//                Image(
//                    bitmap = bitmap,
//                    contentDescription = null,
//                    modifier = Modifier
//                        .defaultMinSize(minWidth = 64.dp, minHeight = 64.dp)
//                        .padding(top = 8.dp)
//                )
//            }
            WeatherIcon(imageState, 64.dp, 64.dp)

            weatherCard.date?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.h6
                )
            }

            Text(
                text = "Rain: ${weatherCard.chanceOfRain}%",
                style = MaterialTheme.typography.caption,
            )
            Text(
                text = "Snow: ${weatherCard.chanceOfSnow?.toDouble()}%",
                modifier = Modifier.padding(bottom = 10.dp),
                style = MaterialTheme.typography.caption,
            )
        }
    }

}