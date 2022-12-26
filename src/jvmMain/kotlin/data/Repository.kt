package data
import utility.ScreenState
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.utils.io.errors.*

// Todo: Study  all of this
class Repository(
  private val apiKey: String,
  private val client: HttpClient = defaultHttpClient,
) {

  private val dataMapper = Mappers()

  private suspend fun getWeatherForCity(city: String): WeatherResponse =
    client.get(
      "https://api.weatherapi.com/v1/forecast.json" +
          "?key=$apiKey" +
          "&q=$city" +
          "&days=5" +
          "&aqi=no" +
          "&alerts=no"
    )

  suspend fun getWeather(city: String): ScreenState<WeatherResults> {
    return try {
      val response = getWeatherForCity(city)
      val results = dataMapper.mapData(response)
      ScreenState.Content(results)
    } catch (error: IOException) {
      ScreenState.Error(error)
    }
  }

  // HTTP client for getWeatherForCity method.
  companion object {
    val defaultHttpClient = HttpClient(CIO) {
      install(JsonFeature) {
        serializer = KotlinxSerializer(
          json = kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
          }
        )
      }
    }
  }
}
