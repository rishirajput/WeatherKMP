package org.rishirajput.weatherkmp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.rishirajput.weatherkmp.presentation.ui.compose.HomeScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        HomeScreen(PaddingValues(0.dp))
    }
}