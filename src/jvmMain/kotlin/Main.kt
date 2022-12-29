import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import screens.MainWindow
import viewModel.WeatherViewModel


/*
    Todo:
        - Error handling - no matching location found crashes application
        - Typography
        - Format date for Updated in details card
        - If paid subscription - horizontal scroll in forecast section
        - Clean up the data models
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

