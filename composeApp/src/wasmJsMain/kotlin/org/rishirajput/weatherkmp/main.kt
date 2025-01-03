package org.rishirajput.weatherkmp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.koin.core.context.GlobalContext.startKoin
import org.rishirajput.weatherkmp.di.dataModule
import org.rishirajput.weatherkmp.di.viewModelModule

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    startKoin {
        modules(dataModule, viewModelModule)
    }
    ComposeViewport(document.body!!) {
        App()
    }
}