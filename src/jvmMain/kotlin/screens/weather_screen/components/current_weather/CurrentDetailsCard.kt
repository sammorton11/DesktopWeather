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

@Composable
fun CurrentDetailsCard(data: WeatherResults){
    // Details card
    // Todo: Use data from models instead of fake data for testing
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
                    Text("Updated:")
                    Text("Wind Speed:")
                    Text("Humidity:")
                    Text("UV:")
                    Text("Gust:")
                }

                Column (
                    modifier = Modifier.padding(15.dp)
                ){
                    Text("${data.currentWeather.lastUpdated}")
                    Text("${data.currentWeather.windSpeed} mph")
                    Text("45.0%")
                    Text("1.0")
                    Text("15mph")
                }
            }


//                Spacer(Modifier.padding(start = 140.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                ){
                    Text("Test:")
                    Text("Test Speed:")
                    Text("Test:")
                    Text("Test:")
                    Text("Test:")
                }

                Column (
                    modifier = Modifier.padding(15.dp)
                ){
                    Text("12/25/2022")
                    Text("5 mph")
                    Text("45.0%")
                    Text("1.0")
                    Text("15mph")
                }
            }

        }
    }
}