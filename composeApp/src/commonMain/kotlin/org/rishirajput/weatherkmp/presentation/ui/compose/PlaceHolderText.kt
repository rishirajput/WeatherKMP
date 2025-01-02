package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.rishirajput.weatherkmp.presentation.ui.theme.onSurfaceColor
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Composable function to display placeholder text.
 *
 * @param placeholderText The text to display as a placeholder.
 */
@Composable
fun PlaceHolderText(placeholderText: String) {
    Text(
        text = placeholderText,
        style = MaterialTheme.typography.bodyLarge.copy(
            color = onSurfaceColor
        )
    )
}

/**
 * Preview function for PlaceHolderText composable.
 */
@Preview
@Composable
fun PlaceHolderTextPreview() {
    PlaceHolderText(placeholderText = "Search Location")
}