package com.ezgieren.weatherapp.data.remote.dto

import com.ezgieren.weatherapp.domain.model.WeatherInfo

data class WeatherResponseDto(
    val name: String,
    val weather: List<WeatherDto>,
    val main: MainDto,
    val wind: WindDto
)
fun WeatherResponseDto.toWeatherInfo(): WeatherInfo {
    return WeatherInfo(
        cityName = name,
        description = weather.firstOrNull()?.description ?: "",
        temperature = main.temp,
        pressure = main.pressure,
        humidity = main.humidity,
        windSpeed = wind.speed,
        icon = weather.firstOrNull()?.icon ?: ""
    )
}

data class WeatherDto(
    val description: String,
    val icon: String
)

data class MainDto(
    val temp: Double,
    val pressure: Int,
    val humidity: Int
)

data class WindDto(
    val speed: Double
)