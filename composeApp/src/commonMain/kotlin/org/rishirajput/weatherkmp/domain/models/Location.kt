package com.rishirajput.domain.model

import kotlinx.serialization.Serializable

/**
 * Data class representing a geographical location.
 *
 * @param id The unique identifier for the location.
 * @param name The name of the location.
 * @param region The region where the location is situated.
 * @param country The country where the location is situated.
 * @param lat The latitude coordinate of the location.
 * @param lon The longitude coordinate of the location.
 * @param url The URL for more information about the location.
 */
@Serializable
data class Location(
    val id: Int,
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val url: String
)