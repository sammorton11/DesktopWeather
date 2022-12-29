package data

import java.text.SimpleDateFormat

class Mappers {

    private fun currentWeatherData(response: WeatherResponse): WeatherCard {
        return WeatherCard(
            condition = response.current.condition.text,
            iconUrl = "https:" + response.current.condition.icon.replace("64x64", "128x128"),
            temperature = response.current.tempC,
            feelsLike = response.current.feelslikeC,
            date = response.location.localtime,
            name = response.location.name,
            region = response.location.region,
            country = response.location.country,
            windSpeed = response.current.windSpeed,
            lastUpdated = response.current.lastUpdated,
            humidity = response.current.humidity,
            gustSpeed = response.current.gustSpeed,
            uv = response.current.uv,
            clouds = response.current.clouds,
            windDirection = response.current.windDirection,
            timeZone = response.location.tz_id,
            precipitationInches = response.current.precipitationInches,
            dayOfWeek = response.current.dayOfWeek

        )
    }
    
    private fun forecastData(response: WeatherResponse): List<WeatherCard> {
        return response.forecast.forecastday.map { forecastDay ->
            WeatherCard(
                condition = forecastDay.day.condition.text,
                iconUrl = "https:" + forecastDay.day.condition.icon,
                temperature = forecastDay.day.avgtempF,
                chanceOfSnow = forecastDay.day.chanceOfSnow,
                feelsLike = avgFeelsLike(forecastDay),
                chanceOfRain = avgChanceOfRain(forecastDay),
                date = getTime(forecastDay)
            )
        }
    }

    private fun avgFeelsLike(forecastDay: Forecastday): Double =
        forecastDay.hour.map(Hour::feelslikeC).average()

    private fun avgChanceOfRain(forecastDay: Forecastday): Double =
        forecastDay.hour.map(Hour::chanceOfRain).average()


    private fun getTime(forecastDay: Forecastday): String {
        return formatDate(forecastDay.date.toString())
    }


    fun mapData(response: WeatherResponse): WeatherResults {
        val current = currentWeatherData(response)
        val forecast = forecastData(response)

        return WeatherResults(
            currentWeather = current,
            forecast = forecast,
        )
    }
}

// This is hacky
fun formatDate(text: String): String {
    val monthDayFormat = SimpleDateFormat("MM-dd")
    return text.replace("2022-", "")
}
