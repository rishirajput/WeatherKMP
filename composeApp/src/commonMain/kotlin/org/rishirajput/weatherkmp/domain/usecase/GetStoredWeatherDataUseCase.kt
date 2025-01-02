package org.rishirajput.weatherkmp.domain.usecase

import org.rishirajput.weatherkmp.domain.models.WeatherData
import org.rishirajput.weatherkmp.domain.repository.LocalStorageRepository

/**
 * Use case for retrieving the selected weather data from local storage.
 *
 * @property localStorageRepository The repository to retrieve weather data from.
 */
class GetStoredWeatherDataUseCase(private val localStorageRepository: LocalStorageRepository) {

    /**
     * Invokes the use case to retrieve the selected weather data.
     *
     * @return The selected [WeatherData], or null if no data is found.
     */
    suspend operator fun invoke(): WeatherData? {
        return localStorageRepository.getWeatherData()
    }
}