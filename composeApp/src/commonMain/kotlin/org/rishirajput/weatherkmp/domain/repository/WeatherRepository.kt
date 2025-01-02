package org.rishirajput.weatherkmp.domain.repository

import org.rishirajput.weatherkmp.domain.models.Location
import org.rishirajput.weatherkmp.domain.models.WeatherData
import org.rishirajput.weatherkmp.domain.models.Result

/**
 * Interface representing a repository for fetching weather data and locations.
 */
interface WeatherRepository {
    /**
     * Fetches weather data based on the given query.
     *
     * @param query The query string to search for weather data.
     * @return A [Result] containing a list of [WeatherData].
     */
    suspend fun getWeatherData(query: String): Result<List<WeatherData>>

    /**
     * Fetches locations based on the given query.
     *
     * @param query The query string to search for locations.
     * @return A [Result] containing a list of [Location].
     */
    suspend fun getLocations(query: String): Result<List<Location>>

    /**
     * Fetches weather data for a specific location.
     *
     * @param locationName The name of the location to fetch weather data for.
     * @return A [Result] containing the [WeatherData] for the specified location.
     */
    suspend fun getWeatherDataForLocation(locationName: String): Result<WeatherData>
}