package org.example.weatherkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform