package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rishirajput.weatherkmp.domain.models.WeatherData

/**
 * Composable function to display the details of a location's weather.
 *
 * @param weatherData The weather data to display.
 */
@Composable
fun LocationDetail(weatherData: WeatherData) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(56.dp)
    ) {
        WeatherStatusIcon(
            iconUrl = weatherData.icon,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(11.dp))
        LocationName(
            locationName = weatherData.locationName,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        CurrentTemperature(
            temperature = weatherData.temperature,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        WeatherInfo(
            weatherData = weatherData,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

/**
 * Preview function for LocationDetail composable.
 */
@Preview
@Composable
fun PreviewLocationDetail() {
    val dummyWeatherData = WeatherData(
        locationName = "Hyderabad",
        temperature = 31.0,
        condition = "Patchy rain nearby",
        icon = "//cdn.weatherapi.com/weather/64x64/night/176.png",
        humidity = 76,
        uvIndex = 4.0,
        feelsLike = 30.4
    )
    LocationDetail(weatherData = dummyWeatherData)
}