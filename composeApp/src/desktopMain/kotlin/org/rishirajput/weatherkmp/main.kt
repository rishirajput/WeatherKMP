package org.rishirajput.weatherkmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.koin.core.context.startKoin
import org.rishirajput.weatherkmp.di.dataModule
import org.rishirajput.weatherkmp.di.viewModelModule

fun main() = application {
    startKoin {
        modules(dataModule, viewModelModule)
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Weather",
    ) {
        App()
    }
}