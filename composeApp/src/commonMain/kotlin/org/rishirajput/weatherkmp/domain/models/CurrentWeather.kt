package com.rishirajput.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data class representing the current weather details.
 *
 * @param tempC The current temperature in Celsius.
 * @param condition The weather condition details.
 * @param humidity The current humidity percentage.
 * @param uv The current UV index.
 * @param feelsLikeC The feels-like temperature in Celsius.
 */
@Serializable
data class CurrentWeather(
    @SerialName("temp_c") val tempC: Double,
    val condition: Condition,
    val humidity: Int,
    val uv: Double,
    @SerialName("feelslike_c") val feelsLikeC: Double
)