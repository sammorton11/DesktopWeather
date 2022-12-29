package screens.weather_screen.components.current_weather

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import data.WeatherResults
import screens.weather_screen.components.CityLocation
import screens.weather_screen.components.TempTextView
import screens.weather_screen.components.WeatherIcon
import utility.Constants

@Composable
fun CurrentWeatherCard(
    data: WeatherResults,
    image: ImageBitmap?,
    temp: Int,
    feelsLike: Int
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 72.dp)
            .padding(bottom = 20.dp),
        backgroundColor = Color.LightGray,
        elevation = Constants.card_elevation
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            WeatherIcon(image, 100.dp, 100.dp)
            CityLocation(data)
            TempTextView(temp)

            Text(
                text = data.currentWeather.condition,
                style = MaterialTheme.typography.caption,
            )

            Spacer(Modifier.padding(5.dp))

            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Feels like: $feelsLike",
                    modifier = Modifier.padding(start = 5.dp),
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = "°",
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}