package org.rishirajput.weatherkmp.data.serializer

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Serializer for WeatherData using Kotlinx Serialization.
 */
object WeatherDataSerializer {
    @Serializable
    data class WeatherData(val temperature: Double, val humidity: Double)

    val defaultValue: WeatherData? = null

    fun fromJson(json: String): WeatherData? {
        return try {
            Json.decodeFromString<WeatherData>(json)
        } catch (exception: Exception) {
            throw Exception("Cannot read JSON.", exception)
        }
    }

    fun toJson(t: WeatherData?): String {
        return try {
            Json.encodeToString(t)
        } catch (exception: Exception) {
            throw Exception("Cannot write JSON.", exception)
        }
    }
}