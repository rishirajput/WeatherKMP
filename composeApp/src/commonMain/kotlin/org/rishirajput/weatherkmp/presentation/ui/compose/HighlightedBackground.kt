package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.rishirajput.weatherkmp.presentation.ui.theme.highLightColor

/**
 * Extension function to apply a highlighted background with a rounded corner shape.
 *
 * @param color The background color to be applied. Defaults to highLightColor.
 * @return The modified Modifier with the highlighted background.
 */
fun Modifier.highLightedBackGround(color: Color = highLightColor): Modifier = this
    .background(color, shape = RoundedCornerShape(16.dp))