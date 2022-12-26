import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import screens.MainWindow
import viewModel.WeatherViewModel


/*
    Todo:
        - Text in text TextView is too dark
        - data.Condition text should be in a different place
        - Typography
        -
        - Maybe pay for the pro plan to be able to have more days in the forecast
        - Change color of Cards and rest of UI
        - Clean up code
        - Separate component into composable functions
        - Good job!
 */

fun main() = application {
    val presenter = WeatherViewModel()

    Window(
        onCloseRequest = ::exitApplication,
        title = "Kotlin Weather"
    ) {
        MainWindow(presenter)
    }
}

