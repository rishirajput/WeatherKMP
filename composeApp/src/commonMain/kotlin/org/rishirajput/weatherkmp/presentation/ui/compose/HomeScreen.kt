package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.rishirajput.weatherkmp.presentation.ui.theme.appBackgroundColor
import org.rishirajput.weatherkmp.presentation.ui.viewmodel.WeatherViewModel

/**
 * Composable function to display the home screen of the weather app.
 *
 * @param innerPadding The padding values to be applied to the screen.
 */
@Composable
fun HomeScreen(innerPadding: PaddingValues) {
    val viewModel: WeatherViewModel = koinViewModel<WeatherViewModel>()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val searchResults by viewModel.searchResults.collectAsState()
    val storedWeatherData by viewModel.storedWeatherData.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val focusManager = LocalFocusManager.current
    val snackBarHostState = remember { SnackbarHostState() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(appBackgroundColor)
            .padding(innerPadding)
    ) {
        HomeScreenContent(
            searchQuery = searchQuery,
            searchResults = searchResults,
            storedWeatherData = storedWeatherData,
            isLoading = isLoading,
            onSearch = { viewModel.fetchWeatherData(it) },
            onLocationClick = { data -> viewModel.selectWeatherData(data) },
            focusManager = focusManager
        )
        SnackbarHost(
            hostState = snackBarHostState, modifier = Modifier.align(Alignment.BottomCenter)
        )
        ErrorSnackBar(snackBarHostState = snackBarHostState, errorFlow = viewModel.errorFlow)
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(innerPadding = PaddingValues())
}