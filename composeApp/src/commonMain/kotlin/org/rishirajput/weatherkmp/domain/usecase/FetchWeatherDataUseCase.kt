package org.rishirajput.weatherkmp.domain.usecase

import org.rishirajput.weatherkmp.domain.models.WeatherData
import org.rishirajput.weatherkmp.domain.repository.WeatherRepository
import org.rishirajput.weatherkmp.domain.models.Result

/**
 * Use case for fetching weather data based on a query.
 *
 * @property repository The repository to fetch weather data from.
 */
class FetchWeatherDataUseCase(private val repository: WeatherRepository) {

    /**
     * Invokes the use case to fetch weather data.
     *
     * @param query The query string to search for weather data.
     * @return A [Result] containing a list of [WeatherData].
     */
    suspend operator fun invoke(query: String): Result<List<WeatherData>> {
        return repository.getWeatherData(query)
    }
}