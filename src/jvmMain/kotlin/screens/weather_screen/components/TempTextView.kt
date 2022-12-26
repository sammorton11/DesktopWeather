package screens.weather_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TempTextView(temp: Int){
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 38.dp, end = 25.dp, top = 25.dp, bottom = 35.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "$temp",
            modifier = Modifier.padding(start = 10.dp, end = 5.dp),
            style = MaterialTheme.typography.h3,
        )
        Text(
            text = "°F",
            modifier = Modifier.padding(end = 10.dp),
            fontSize = 35.sp,
            style = MaterialTheme.typography.caption,
        )

    }
}