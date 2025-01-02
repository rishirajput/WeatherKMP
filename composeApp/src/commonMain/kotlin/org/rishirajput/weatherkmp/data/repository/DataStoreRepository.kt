package org.rishirajput.weatherkmp.data.repository

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set
import org.rishirajput.weatherkmp.data.serializer.WeatherDataSerializer
import org.rishirajput.weatherkmp.domain.models.WeatherData
import org.rishirajput.weatherkmp.domain.repository.LocalStorageRepository

/**
 * Repository for managing weather data storage using Multiplatform Settings.
 */
class DataStoreRepository(
    private val settings: Settings
) : LocalStorageRepository {

    override suspend fun storeWeatherData(weatherData: WeatherData) {
        val json = WeatherDataSerializer.toJson(weatherData)
        settings["weather_data"] = json
    }

    override suspend fun getWeatherData(): WeatherData? {
        val json = settings["weather_data", ""]
        return if (json.isNotEmpty()) {
            WeatherDataSerializer.fromJson(json)
        } else {
            null
        }
    }
}