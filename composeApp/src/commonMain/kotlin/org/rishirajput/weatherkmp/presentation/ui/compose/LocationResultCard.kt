package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rishirajput.weatherkmp.domain.models.WeatherData
import org.rishirajput.weatherkmp.presentation.ui.theme.provideTextStyleCurrentTemperature
import org.rishirajput.weatherkmp.presentation.ui.theme.provideTextStyleLocationName

/**
 * Composable function to display a card with weather information for a location.
 *
 * @param weatherData The weather data to display.
 * @param onClick The action to perform when the card is clicked.
 */
@Composable
fun LocationResultCard(weatherData: WeatherData, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .highLightedBackGround()
            .clickable(onClick = onClick)
            .padding(start = 30.dp, top = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = weatherData.locationName,
                style = provideTextStyleLocationName()
            )
            CurrentTemperature(
                temperature = weatherData.temperature,
                modifier = Modifier.align(Alignment.Start),
                textStyle = provideTextStyleCurrentTemperature()
            )
        }
        WeatherStatusIcon(
            iconUrl = weatherData.icon,
            modifier = Modifier
                .height(110.dp)
                .width(110.dp)
                .padding(bottom = 8.dp)
        )
    }
}

/**
 * Preview function for LocationResultCard composable.
 */
@Preview
@Composable
fun PreviewLocationResult() {
    val dummyWeatherData = WeatherData(
        locationName = "YoriCostio (La Villita)",
        temperature = 27.3,
        condition = "Patchy rain nearby",
        icon = "//cdn.weatherapi.com/weather/64x64/night/176.png",
        humidity = 76,
        uvIndex = 0.1,
        feelsLike = 30.4
    )
    LocationResultCard(weatherData = dummyWeatherData) {}
}