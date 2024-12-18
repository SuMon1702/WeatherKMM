package org.example.weatherkmm.Model

data class Current(
    val cloud_cover: Int,
    val interval: Int,
    val is_day: Int,
    val temperature_2m: Double,
    val time: String,
    val weather_code: Int,
    val wind_direction_10m: Int,
    val wind_speed_10m: Double
)