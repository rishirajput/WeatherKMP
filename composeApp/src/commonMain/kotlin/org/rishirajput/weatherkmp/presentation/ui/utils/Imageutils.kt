package org.rishirajput.weatherkmp.presentation.ui.utils

/**
 * Updates the image size in the given URL to the specified new size.
 *
 * @param url The original URL containing the image size.
 * @param newSize The new size to be applied to the image URL.
 * @return The updated URL with the new image size.
 */
fun updateImageSizeInUrl(url: String, newSize: Int): String {
    val sizePattern = Regex("""/(\d+)x(\d+)/""")
    return sizePattern.replace(url) { _ ->
        "/${newSize}x${newSize}/"
    }
}