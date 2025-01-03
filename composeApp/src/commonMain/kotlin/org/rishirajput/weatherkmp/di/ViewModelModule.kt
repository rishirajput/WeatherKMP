package org.rishirajput.weatherkmp.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.rishirajput.weatherkmp.presentation.ui.viewmodel.WeatherViewModel

val viewModelModule = module {
    factoryOf(::WeatherViewModel)
}