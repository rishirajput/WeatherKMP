package org.rishirajput.weatherkmp.data.serializer

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.rishirajput.weatherkmp.domain.models.WeatherData

/**
 * Serializer for WeatherData using Kotlinx Serialization.
 */
object WeatherDataSerializer {

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