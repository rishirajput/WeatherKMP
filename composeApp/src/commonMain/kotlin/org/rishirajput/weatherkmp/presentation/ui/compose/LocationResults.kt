package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rishirajput.weatherkmp.domain.models.WeatherData

/**
 * Composable function to display a list of location results.
 *
 * @param searchResults The list of weather data to display.
 * @param onLocationClick The action to perform when a location is clicked.
 * @param focusManager The focus manager to handle focus actions.
 * @param modifier The modifier to be applied to the composable.
 */
@Composable
fun LocationResults(
    searchResults: List<WeatherData>,
    onLocationClick: (WeatherData) -> Unit,
    focusManager: FocusManager,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(searchResults) { weatherData ->
            LocationResultCard(
                weatherData = weatherData,
                onClick = {
                    onLocationClick(weatherData)
                    focusManager.clearFocus()
                }
            )
        }
    }
}

/**
 * Preview function for LocationResults composable.
 */
@Preview
@Composable
fun PreviewLocationResults() {
    val dummyWeatherDataList = listOf(
        WeatherData(
            locationName = "Hyderabad",
            temperature = 31.0,
            condition = "Patchy rain nearby",
            icon = "//cdn.weatherapi.com/weather/64x64/night/176.png",
            humidity = 76,
            uvIndex = 4.0,
            feelsLike = 30.4
        ),
        WeatherData(
            locationName = "Mumbai",
            temperature = 29.0,
            condition = "Clear",
            icon = "//cdn.weatherapi.com/weather/64x64/night/113.png",
            humidity = 80,
            uvIndex = 5.0,
            feelsLike = 32.0
        )
    )
    val focusManager = LocalFocusManager.current
    LocationResults(
        searchResults = dummyWeatherDataList,
        onLocationClick = {},
        focusManager = focusManager
    )
}