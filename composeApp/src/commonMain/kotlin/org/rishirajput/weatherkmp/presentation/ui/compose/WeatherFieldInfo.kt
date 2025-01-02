package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rishirajput.weatherkmp.presentation.ui.theme.provideTextStyleMedium
import org.rishirajput.weatherkmp.presentation.ui.theme.provideTextStyleSmall

/**
 * Composable function to display weather field information.
 *
 * @param label The label for the weather field.
 * @param value The value for the weather field.
 */
@Composable
fun WeatherFieldInfo(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            style = provideTextStyleSmall(),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = value,
            style = provideTextStyleMedium(),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

/**
 * Preview function for WeatherFieldInfo composable.
 */
@Preview()
@Composable
fun PreviewWeatherFieldInfo() {
    WeatherFieldInfo(label = "Humidity", value = "76%")
}