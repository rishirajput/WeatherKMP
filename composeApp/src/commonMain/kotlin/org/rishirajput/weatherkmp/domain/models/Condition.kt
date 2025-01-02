package com.rishirajput.domain.model

import kotlinx.serialization.Serializable

/**
 * Data class representing weather condition details.
 *
 * @param text The description of the weather condition.
 * @param icon The URL of the icon representing the weather condition.
 */
@Serializable
data class Condition(
    val text: String,
    val icon: String
)