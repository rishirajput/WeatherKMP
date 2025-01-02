package org.rishirajput.weatherkmp.presentation.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import weather.composeapp.generated.resources.Res
import weather.composeapp.generated.resources.search_location

/**
 * Composable function to display a search bar.
 *
 * @param query The current search query.
 * @param placeholderText The text to display as a placeholder.
 * @param modifier The modifier to be applied to the composable.
 * @param onSearch The action to perform when the search query changes.
 */
@Composable
fun SearchBar(
    query: String,
    placeholderText: String,
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(46.dp)
            .highLightedBackGround()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = query,
            onValueChange = onSearch,
            textStyle = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (query.isEmpty()) {
                        PlaceHolderText(placeholderText = placeholderText)
                    }
                    innerTextField()
                }
            }
        )
        SearchIcon()
    }
}

/**
 * Preview function for SearchBar composable.
 */
@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(
        query = "",
        placeholderText = stringResource(Res.string.search_location),
        onSearch = {}
    )
}