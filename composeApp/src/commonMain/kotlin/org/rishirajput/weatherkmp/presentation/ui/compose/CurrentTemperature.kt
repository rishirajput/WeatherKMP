package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rishirajput.weatherkmp.presentation.ui.theme.provideTextStyleTemperatureLarge
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.degree_icon

/**
 * Composable function to display the current temperature with a degree icon.
 *
 * @param temperature The current temperature to display.
 * @param modifier The modifier to be applied to the Row layout.
 * @param textStyle The text style to be applied to the temperature text.
 */
@Composable
fun CurrentTemperature(
    temperature: Double,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = provideTextStyleTemperatureLarge()
) {
    Row(
        modifier = modifier
    ) {
        Text(
            text = "$temperature",
            style = textStyle,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.width(11.dp))
        Image(
            painter = painterResource(Res.drawable.degree_icon),
            contentDescription = stringResource(Res.string.degree_icon),
            modifier = Modifier
                .align(Alignment.Top)
                .offset(y = 16.dp)
        )
    }
}

@Preview()
@Composable
fun PreviewCurrentTemperature() {
    CurrentTemperature(
        temperature = 25.0,
        modifier = Modifier,
        textStyle = provideTextStyleTemperatureLarge()
    )
}