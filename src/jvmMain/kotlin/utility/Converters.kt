package utility

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlin.math.nextDown
import kotlin.math.roundToInt

object Converters {

    fun Double.roundTemperature(): Int {
        return this.roundToInt()
    }

    fun dayOfWeekConverter(day: Int): String{
        var weekDay = ""
        when(day){
            0 -> weekDay = "Sunday"
            1 -> weekDay = "Monday"
            2 -> weekDay = "Tuesday"
            3 -> weekDay = "Wednesday"
            4 -> weekDay = "Thursday"
            5 -> weekDay = "Friday"
            6 -> weekDay = "Saturday"
        }

        return weekDay
    }
}