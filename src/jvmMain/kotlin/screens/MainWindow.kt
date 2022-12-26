package screens

import screens.weather_screen.WeatherScreen
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import viewModel.WeatherViewModel

/*
    MainWindow Composable
        - Displays the weather data in a lazy vertical scrolling list
        - Has a vertical scrollbar
        - Has a dark gray background color
        - Pads the inside edges by 10dp
 */
@Composable
fun MainWindow(viewModel: WeatherViewModel) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.DarkGray)
            .padding(10.dp)
    ) {

        val state = rememberLazyListState()

        LazyColumn(Modifier.fillMaxSize().padding(end = 12.dp), state) {
            item {
                WeatherScreen(viewModel)
            }

        }
        VerticalScrollbar(
            modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
            adapter = rememberScrollbarAdapter(
                scrollState = state
            )
        )
    }
}