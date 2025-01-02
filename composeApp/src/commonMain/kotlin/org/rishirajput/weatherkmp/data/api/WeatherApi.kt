package org.rishirajput.weatherkmp.data.api

import org.rishirajput.weatherkmp.domain.models.Location
import org.rishirajput.weatherkmp.domain.models.WeatherResponse

/**
 * Service interface for accessing weather-related API endpoints.
 */
interface WeatherApi {

    /**
     * Fetches the current weather for a given location.
     *
     * @param key The API key for authentication.
     * @param q The location query (e.g., city name or coordinates).
     * @return A [Result] containing the current weather data.
     */
    suspend fun getCurrentWeather(
        key: String, q: String
    ): Result<WeatherResponse>

    /**
     * Searches for locations matching the given query.
     *
     * @param key The API key for authentication.
     * @param q The location query (e.g., city name or coordinates).
     * @return A [Result] containing a list of matching locations.
     */

    suspend fun searchLocation(
        key: String, q: String
    ): Result<List<Location>>
}