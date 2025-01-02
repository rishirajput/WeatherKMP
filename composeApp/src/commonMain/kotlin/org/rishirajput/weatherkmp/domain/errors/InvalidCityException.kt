package org.rishirajput.weatherkmp.domain.errors

/**
 * Exception thrown when an invalid city is encountered.
 *
 * @param message The detail message for this exception.
 */
class InvalidCityException(message: String = "Invalid city name provided.") : Exception(message)