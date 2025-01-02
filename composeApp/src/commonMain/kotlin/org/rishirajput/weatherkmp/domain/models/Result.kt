package com.rishirajput.domain.model

/**
 * A sealed class representing the result of an operation, which can be a success, error, or loading state.
 */
sealed class Result<out T> {
    /**
     * Represents a successful result containing the data.
     *
     * @param data The data of the successful result.
     */
    data class Success<out T>(val data: T) : Result<T>()

    /**
     * Represents an error result containing the exception.
     *
     * @param exception The exception of the error result.
     */
    data class Error(val exception: Throwable) : Result<Nothing>()
}