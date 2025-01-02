package org.rishirajput.weatherkmp.domain.usecase

import org.rishirajput.weatherkmp.domain.models.WeatherData
import org.rishirajput.weatherkmp.domain.repository.LocalStorageRepository

/**
 * Use case for storing weather data in local storage.
 *
 * @property localStorageRepository The repository to store weather data in.
 */
class StoreWeatherDataUseCase(private val localStorageRepository: LocalStorageRepository) {

    /**
     * Invokes the use case to store the given weather data.
     *
     * @param data The weather data to store.
     */
    suspend operator fun invoke(data: WeatherData) {
        localStorageRepository.storeWeatherData(data)
    }
}