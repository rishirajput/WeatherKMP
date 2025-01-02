package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rishirajput.weatherkmp.presentation.ui.theme.onSurfaceColor
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.icon_action_search
import weather.composeapp.generated.resources.search_icon

/**
 * Composable function to display a search icon.
 */
@Composable
fun SearchIcon(modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(Res.drawable.icon_action_search),
        contentDescription = stringResource(Res.string.search_icon),
        tint = onSurfaceColor,
        modifier = modifier.size(17.49.dp)
    )
}

/**
 * Preview function for SearchIcon composable.
 */
@Preview
@Composable
fun SearchIconPreview() {
    SearchIcon()
}