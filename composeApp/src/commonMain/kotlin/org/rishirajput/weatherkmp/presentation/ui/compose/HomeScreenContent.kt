package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rishirajput.weatherkmp.domain.models.WeatherData
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.search_location

/**
 * Composable function to display the content of the home screen.
 *
 * @param searchQuery The current search query.
 * @param searchResults The list of search results.
 * @param storedWeatherData The stored weather data.
 * @param isLoading A boolean indicating if the data is loading.
 * @param onSearch A lambda function to handle search actions.
 * @param onLocationClick A lambda function to handle location click actions.
 * @param focusManager The focus manager to handle focus actions.
 */
@Composable
fun HomeScreenContent(
    searchQuery: String,
    searchResults: List<WeatherData>,
    storedWeatherData: WeatherData?,
    isLoading: Boolean,
    onSearch: (String) -> Unit,
    onLocationClick: (WeatherData) -> Unit,
    focusManager: FocusManager
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(44.dp))
        SearchBar(
            query = searchQuery,
            placeholderText = stringResource(Res.string.search_location),
            modifier = Modifier.padding(24.dp),
            onSearch = onSearch
        )
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            when {
                storedWeatherData != null && searchQuery.isEmpty() -> {
                    LocationDetail(weatherData = storedWeatherData)
                }

                searchResults.isNotEmpty() -> {
                    LocationResults(
                        searchResults = searchResults,
                        onLocationClick = onLocationClick,
                        focusManager = focusManager,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                searchQuery.isEmpty() -> {
                    NoCitySelected()
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreenContent() {
    val dummyWeatherData = WeatherData(
        locationName = "Hyderabad",
        temperature = 31.0,
        condition = "Patchy rain nearby",
        icon = "//cdn.weatherapi.com/weather/64x64/night/176.png",
        humidity = 76,
        uvIndex = 4.0,
        feelsLike = 30.4
    )
    HomeScreenContent(
        searchQuery = "",
        searchResults = listOf(dummyWeatherData),
        storedWeatherData = dummyWeatherData,
        isLoading = false,
        onSearch = {},
        onLocationClick = {},
        focusManager = LocalFocusManager.current
    )
}