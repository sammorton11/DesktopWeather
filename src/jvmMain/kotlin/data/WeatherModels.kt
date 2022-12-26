package data
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
  val current: Current,
  val forecast: Forecast,
  val location: Location
)

@Serializable
data class Current(
  @SerialName("temp_c")
  val tempC: Double,
  val condition: Condition,
  @SerialName("feelslike_c")
  val feelslikeC: Double,
  @SerialName("cloud")
  val clouds: Int,
  @SerialName("humidity")
  val humidity: Int,
  @SerialName("wind_mph")
  val windSpeed: Double,
  @SerialName("wind_dir")
  val windDirection: String,
  @SerialName("uv")
  val uv: Double,
  @SerialName("gust_mph")
  val gustSpeed: Double,
  @SerialName("last_updated")
  val lastUpdated: String
)

@Serializable
data class Condition(
  val text: String,
  val icon: String
)

@Serializable
data class Forecast(
  val forecastday: List<Forecastday>
)

@Serializable
data class Forecastday(
  @SerialName("date")
  val date: String?,
  val day: Day,
  val hour: List<Hour>
)

@Serializable
data class Day(
  @SerialName("avgtemp_c")
  val avgtempC: Double,
  val condition: Condition,
  @SerialName("daily_chance_of_snow")
  val chanceOfSnow: Int
)

@Serializable
data class Hour(
  @SerialName("feelslike_c")
  val feelslikeC: Double,
  @SerialName("chance_of_rain")
  val chanceOfRain: Int,
  @SerialName("time")
  val time: String
)

@Serializable
data class Location(
  @SerialName("name")
  val name: String,
  @SerialName("region")
  val region: String,
  @SerialName("country")
  val country: String,
  @SerialName("lat")
  val lat: Double,
  @SerialName("lon")
  val lon: Double,
  @SerialName("tz_id")
  val tz_id: String,
  @SerialName("localtime_epoch")
  val localtime_epoch: Long,
  @SerialName("localtime")
  val localtime: String
)

data class WeatherCard(
  val condition: String,
  val iconUrl: String,
  val temperature: Double,
  val feelsLike: Double,
  val chanceOfRain: Double? = null,
  val chanceOfSnow: Int? = null,
  val date: String? = null,
  val name: String? = null,
  val region: String? = null,
  val country: String? = null,
  val clouds: Int? = null,
  val humidity: Int?= null,
  val windSpeed: Double? = null,
  val windDirection: String? = null,
  val uv: Double? = null,
  val gustSpeed: Double? = null,
  val lastUpdated: String? = null
)

data class WeatherResults(
  val currentWeather: WeatherCard,
  val forecast: List<WeatherCard>,
)
