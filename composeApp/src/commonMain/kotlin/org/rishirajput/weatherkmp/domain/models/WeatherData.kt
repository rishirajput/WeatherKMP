package com.rishirajput.domain.model

import kotlinx.serialization.Serializable

/**
 * Data class representing weather data details.
 *
 * @param locationName The name of the location.
 * @param temperature The current temperature.
 * @param condition The weather condition description.
 * @param icon The URL of the weather condition icon.
 * @param humidity The current humidity percentage.
 * @param uvIndex The current UV index.
 * @param feelsLike The feels-like temperature.
 */
@Serializable
data class WeatherData(
    val locationName: String,
    val temperature: Double,
    val condition: String,
    val icon: String,
    val humidity: Int,
    val uvIndex: Double,
    val feelsLike: Double
)