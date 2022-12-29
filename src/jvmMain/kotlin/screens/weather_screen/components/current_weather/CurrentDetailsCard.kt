package screens.weather_screen.components.current_weather

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.WeatherResults
import utility.Constants
import utility.Converters.dayOfWeekConverter

@Composable
fun CurrentDetailsCard(data: WeatherResults){
    // Details card
    // Todo: Use data from models instead of fake data for testing

    val currentWeather = data.currentWeather
    val day = currentWeather.dayOfWeek?.let { dayOfWeekConverter(it) }


    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 72.dp)
            .padding(bottom = 15.dp),
        backgroundColor = Color.LightGray,
        elevation = Constants.card_elevation
    ){

        Row(
            modifier = Modifier
                .padding(25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                ){
                    Text("Today:")
                    Text("Time Zone:")
                    Text("Updated:")
                    Text("Humidity:")
                    Text("UV:")
                }

                Column (
                    modifier = Modifier.padding(15.dp)
                ){
                    Text("$day")
                    Text("${currentWeather.timeZone}")
                    Text("${currentWeather.lastUpdated}")
                    Text("${currentWeather.humidity}%")
                    Text("${currentWeather.uv}")
                }
            }


//                Spacer(Modifier.padding(start = 140.dp))

            // Todo: this needs real data
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                ){
                    Text("Gust:")
                    Text("Wind Speed:")
                    Text("Wind Direction:")
                    Text("Clouds:")
                    Text("Precipitation:")
//                    Text("Test:")
//                    Text("Test:")
                }

                Column (
                    modifier = Modifier.padding(15.dp)
                ){
                    Text("${currentWeather.gustSpeed} mph")
                    Text("${currentWeather.windSpeed} mph")
                    Text("${currentWeather.windDirection}")
                    Text("${currentWeather.clouds}")
                    Text("${currentWeather.precipitationInches}")
//                    Text("1.0")
//                    Text("15mph")
                }
            }

        }
    }
}