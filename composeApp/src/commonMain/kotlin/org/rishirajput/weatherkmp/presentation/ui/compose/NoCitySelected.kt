package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rishirajput.weatherkmp.presentation.ui.theme.provideTextStyleCityName
import org.rishirajput.weatherkmp.presentation.ui.theme.provideTextStyleSearchCityLabel
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.no_city_selected
import weather.composeapp.generated.resources.please_search_for_a_city

/**
 * Composable function to display a message when no city is selected.
 */
@Composable
fun NoCitySelected(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(Res.string.no_city_selected),
                style = provideTextStyleCityName(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(Res.string.please_search_for_a_city),
                style = provideTextStyleSearchCityLabel(),
                textAlign = TextAlign.Center
            )
        }
    }
}

/**
 * Preview function for NoCitySelected composable.
 */
@Preview
@Composable
fun NoCitySelectedPreview() {
    NoCitySelected()
}