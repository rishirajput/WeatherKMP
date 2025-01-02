package org.rishirajput.weatherkmp.domain.repository

import org.rishirajput.weatherkmp.domain.models.WeatherData

/**
 * Interface representing a local storage repository for weather data.
 */
interface LocalStorageRepository {
    /**
     * Stores the given weather data.
     *
     * @param weatherData The weather data to store.
     */
    suspend fun storeWeatherData(weatherData: WeatherData)

    /**
     * Retrieves the stored weather data.
     *
     * @return The stored weather data, or null if no data is found.
     */
    suspend fun getWeatherData(): WeatherData?
}