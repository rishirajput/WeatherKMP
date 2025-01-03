package org.rishirajput.weatherkmp.di

import com.russhwolf.settings.Settings
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import org.rishirajput.weatherkmp.BuildKonfig
import org.rishirajput.weatherkmp.data.api.KTorWeatherApi
import org.rishirajput.weatherkmp.data.constants.Constants
import org.rishirajput.weatherkmp.data.repository.DataStoreRepository
import org.rishirajput.weatherkmp.data.repository.KTorWeatherRepository
import org.rishirajput.weatherkmp.domain.repository.LocalStorageRepository
import org.rishirajput.weatherkmp.domain.repository.WeatherRepository
import org.rishirajput.weatherkmp.domain.usecase.FetchWeatherDataUseCase
import org.rishirajput.weatherkmp.domain.usecase.GetCurrentWeatherDataUseCase
import org.rishirajput.weatherkmp.domain.usecase.GetStoredWeatherDataUseCase
import org.rishirajput.weatherkmp.domain.usecase.StoreWeatherDataUseCase

val dataModule = module {
    single { provideKTorWeatherApi() }
    single<WeatherRepository> { KTorWeatherRepository(get(), BuildKonfig.WEATHER_API_KEY, Constants.DEBOUNCE_DELAY) }
    single<LocalStorageRepository> { DataStoreRepository(get()) }
    single { FetchWeatherDataUseCase(get()) }
    single { provideSettings() }
    single { StoreWeatherDataUseCase(get()) }
    single { GetStoredWeatherDataUseCase(get()) }
    single { GetCurrentWeatherDataUseCase(get()) }
}

@OptIn(ExperimentalSerializationApi::class)
fun provideKTorWeatherApi(): KTorWeatherApi {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    return KTorWeatherApi(client)
}

fun provideSettings(): Settings {
    return Settings()
}