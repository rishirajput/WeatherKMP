package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rishirajput.weatherkmp.presentation.ui.theme.provideTextStyleCityName
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.location_icon


/**
 * Composable function to display the location name with an icon.
 *
 * @param locationName The name of the location to display.
 * @param modifier The modifier to be applied to the composable.
 */
@Composable
fun LocationName(locationName: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
    ) {
        Text(
            text = locationName,
            style = provideTextStyleCityName(),
            modifier = Modifier.widthIn(max = 268.dp)
        )
        Spacer(modifier = Modifier.width(11.dp))
        Image(
            painter = painterResource(Res.drawable.location_icon),
            contentDescription = stringResource(Res.string.location_icon),
            modifier = Modifier
                .width(21.dp)
                .height(21.dp)
                .align(Alignment.CenterVertically)
        )
    }
}

/**
 * Preview function for LocationName composable.
 */
@Preview
@Composable
fun PreviewLocationName() {
    LocationName(locationName = "YoriCostio (La Villita)")
}