package com.rishirajput.domain.model

import kotlinx.serialization.Serializable

/**
 * Data class representing the weather response.
 *
 * @param current The current weather details.
 */
@Serializable
data class WeatherResponse(
    val current: CurrentWeather
)