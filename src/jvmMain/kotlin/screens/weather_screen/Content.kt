package screens.weather_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import data.WeatherResults
import screens.weather_screen.components.current_weather.CurrentDetailsCard
import screens.weather_screen.components.current_weather.CurrentWeatherCard
import screens.weather_screen.components.current_weather.CurrentWeatherHeading
import screens.weather_screen.components.forecast_weather.ForecastCard
import screens.weather_screen.components.forecast_weather.ForecastHeading
import utility.ImageDownloader
import kotlin.math.roundToInt

/*
    Content Composable
        - Displays the current weather data in a card
            - Icon for the current weather condition
            - Name and region of the city
            - Country of the city
            - Current temperature in Fahrenheit
            - Description of the current weather condition
            - Feels like temperature in Fahrenheit
        - Displays the forecast for the next 5 days in a vertical scrolling list
            - Icon for the weather condition for each day
            - Date of the forecast
            - Max temperature in Fahrenheit
            - Min temperature in Fahrenheit
            - Description of the weather condition
        - Displays an error message if there is an error while loading the weather data
        - Displays a loading indicator while the weather data is being loaded
 */
@Composable
fun Content(data: WeatherResults) {

    var imageState by remember { mutableStateOf<ImageBitmap?>(null) }
    val tempConverted = celsiusToFahrenheit(data.currentWeather.temperature)
    val feelsLikeConverted = celsiusToFahrenheit(data.currentWeather.feelsLike)

    LaunchedEffect(data.currentWeather.iconUrl) {
        imageState = ImageDownloader.downloadImage(data.currentWeather.iconUrl)
    }

    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CurrentWeatherHeading()
        CurrentWeatherCard(
            data = data,
            image = imageState,
            temp = tempConverted,
            feelsLike = feelsLikeConverted
        )
        CurrentDetailsCard(data)
    }

    Divider(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(all = 16.dp),
    )

    ForecastHeading()
    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        items(data.forecast) { weatherCard ->
            ForecastCard(weatherCard)
        }
    }
}


fun celsiusToFahrenheit(celsius: Double): Int {
    val conversion = celsius * 9 / 5 + 32
    return conversion.roundToInt()
}