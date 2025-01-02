package org.rishirajput.weatherkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform