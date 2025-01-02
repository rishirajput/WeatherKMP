package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rishirajput.weatherkmp.domain.models.WeatherData
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.humidity
import weather.composeapp.generated.resources.uv
import weather.composeapp.generated.resources.feels_like

/**
 * Composable function to display weather information.
 *
 * @param weatherData The weather data to display.
 * @param modifier The modifier to be applied to the composable.
 */
@Composable
fun WeatherInfo(weatherData: WeatherData, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .highLightedBackGround()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        WeatherFieldInfo(label = stringResource(Res.string.humidity), value = "${weatherData.humidity}%")
        WeatherFieldInfo(label = stringResource(Res.string.uv), value = "${weatherData.uvIndex}")
        WeatherFieldInfo(label = stringResource(Res.string.feels_like), value = "${weatherData.feelsLike}°")
    }
}

/**
 * Preview function for WeatherInfo composable.
 */
@Preview()
@Composable
fun PreviewWeatherInfo() {
    val dummyWeatherData = WeatherData(
        locationName = "Hyderabad",
        temperature = 31.0,
        condition = "Patchy rain nearby",
        icon = "//cdn.weatherapi.com/weather/64x64/night/176.png",
        humidity = 76,
        uvIndex = 4.0,
        feelsLike = 30.4
    )
    WeatherInfo(weatherData = dummyWeatherData)
}