package screens.weather_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.WeatherResults
import kotlinx.coroutines.launch
import screens.weather_screen.components.OnError
import screens.weather_screen.components.WhenLoading
import utility.ScreenState
import viewModel.WeatherViewModel

/*
    WeatherScreen Composable
        - Contains a search bar and search button for searching for weather data
        - Displays loading, error, or content screens depending on the state of the weather data
        - cityQuerySearch = empty mutable string
        - cityQuerySearch is assigned the text from the text field when the user types
        - Button invokes the fetchData method when clicked with the cityQuerySearch passed in as an argument
 */
@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {

    var cityQuerySearch by remember { mutableStateOf("") }
    var weatherState by remember { mutableStateOf<ScreenState<WeatherResults>?>(null) }
    val scope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        /*
            Search bar for the city
                - Has a city icon
                - Has a placeholder text of "City"
                - Has a label text of "Search for a city"
                - Changes text color to white when focused
                - Changes placeholder text color to light gray when not focused
                - Changes label text color to light gray when not focused and yellow when focused
        */
        OutlinedTextField(
            value = cityQuerySearch,
            enabled = true,
            onValueChange = { cityQuerySearch = it },
            modifier = Modifier.padding(16.dp).weight(1f),
            placeholder = {
                Text(
                    text = "City",
                    style = MaterialTheme.typography.caption
                )},
            label = {
                Text(
                    text = "Search",
                    fontSize = 10.sp,
                    fontStyle = FontStyle.Italic
                )},
            leadingIcon = {
                Icon(
                    Icons.Filled.LocationOn, "Location"
                )},
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                placeholderColor = Color.LightGray,
                unfocusedLabelColor = Color.LightGray,
                focusedLabelColor = Color.Cyan,
                cursorColor = Color.Cyan,
                focusedIndicatorColor = Color.Cyan
            )
        )

        /*
            Search Button
                - Set state to loading
                - Launch coroutine
                - Set state to the fetchData method in the coroutine
         */
        OutlinedButton(
            onClick = {
                weatherState = ScreenState.Loading
                scope.launch {
                    weatherState = viewModel.fetchWeatherData(cityQuerySearch)
                }
            },
            modifier = Modifier.padding(top = 8.dp),
            border = BorderStroke(1.dp, Color.Cyan),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.DarkGray
            ),
            elevation = ButtonDefaults.elevation(10.dp)
        ){
            Icon(Icons.Outlined.Search, "Search", tint = Color.Cyan)
        }
    }


    /*
        When statement to display different screens depending on the state of the weather data
            - If the state is loading, display the WhenLoading screen
            - If the state is an error, display the OnError screen
            - If the state is content, display the Content screen with the weather data
            - If the state is none of the above, do nothing
     */
    when (val state = weatherState) {
        is ScreenState.Loading -> WhenLoading()
        is ScreenState.Error -> OnError()
        is ScreenState.Content -> Content(state.data)
        else -> Unit
    }
}


