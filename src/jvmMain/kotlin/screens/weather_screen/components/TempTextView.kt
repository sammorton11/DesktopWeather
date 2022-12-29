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
            .padding(start = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Row(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "$temp",
                modifier = Modifier.padding(start = 5.dp),
                style = MaterialTheme.typography.h3
            )
            Text(
                text = "°F",
                modifier = Modifier.padding(top = 5.dp),
                style = MaterialTheme.typography.h6
            )
        }

    }
}