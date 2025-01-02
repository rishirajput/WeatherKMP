package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rishirajput.weatherkmp.presentation.ui.utils.updateImageSizeInUrl
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.weather_icon

/**
 * Composable function to display the weather status icon.
 *
 * @param iconUrl The URL of the weather icon.
 * @param modifier The modifier to be applied to the composable.
 */
@Composable
fun WeatherStatusIcon(iconUrl: String, modifier: Modifier = Modifier) {
    val painter = rememberAsyncImagePainter(model = updateImageSizeInUrl("https:$iconUrl", 128))
    Image(
        painter = painter,
        contentDescription = stringResource(Res.string.weather_icon),
        contentScale = ContentScale.Fit,
        modifier = modifier
            .height(128.dp)
            .width(128.dp)
    )
}

/**
 * Preview function for WeatherStatusIcon composable.
 */
@Preview
@Composable
fun PreviewWeatherStatusIcon() {
    WeatherStatusIcon(iconUrl = "//cdn.weatherapi.com/weather/64x64/night/176.png")
}