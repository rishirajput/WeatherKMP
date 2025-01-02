package com.rishirajput.domain.usecase

import com.rishirajput.domain.model.WeatherData
import com.rishirajput.domain.repository.WeatherRepository
import com.rishirajput.domain.model.Result

/**
 * Use case for fetching the current weather data for a specific location.
 *
 * @property weatherRepository The repository to fetch weather data from.
 */
class GetCurrentWeatherDataUseCase(private val weatherRepository: WeatherRepository) {

    /**
     * Invokes the use case to fetch the current weather data.
     *
     * @param weatherData The weather data containing the location name.
     * @return A [Result] containing the [WeatherData] for the specified location, or null if the input is null.
     */
    suspend operator fun invoke(weatherData: WeatherData?): Result<WeatherData>? {
        return weatherData?.let {
            weatherRepository.getWeatherDataForLocation(it.locationName)
        }
    }
}