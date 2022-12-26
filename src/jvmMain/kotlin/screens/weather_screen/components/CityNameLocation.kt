package screens.weather_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.WeatherResults

@Composable
fun CityLocation(data: WeatherResults){
    Column(
        modifier = Modifier.padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "${data.currentWeather.name}, ${data.currentWeather.region}",
            style = MaterialTheme.typography.h6,
        )
        Text(
            text = "${data.currentWeather.country}",
            modifier = Modifier.padding(top = 8.dp, bottom = 5.dp),
            style = MaterialTheme.typography.caption
        )
    }
}