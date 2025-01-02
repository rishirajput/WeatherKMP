package org.rishirajput.weatherkmp.domain.errors

/**
 * Exception thrown when there is no network connection.
 *
 * @param message The detail message for this exception.
 */
class NoNetworkException(message: String = "No network connection available.") : Exception(message)