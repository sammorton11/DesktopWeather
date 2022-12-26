package viewModel

import utility.Constants.API_KEY
import data.Repository
import utility.ScreenState
import data.WeatherResults

class WeatherViewModel(private val repository: Repository = Repository(API_KEY)) {
    suspend fun fetchWeatherData(city: String): ScreenState<WeatherResults> {
        return repository.getWeather(city)
    }
}