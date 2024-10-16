package com.ezgieren.weatherapp.data.remote.dto

import com.ezgieren.weatherapp.domain.model.WeatherInfo
import com.ezgieren.weatherapp.util.Constants

data class WeatherResponseDto(
    val name: String,
    val weather: List<WeatherDto>,
    val main: MainDto,
    val wind: WindDto
)

fun WeatherResponseDto.toWeatherInfo(): WeatherInfo {
    return WeatherInfo(
        cityName = name ?: Constants.UNKNOWN_CITY,
        description = weather.firstOrNull()?.description ?: Constants.UNKNOWN_TEXT,
        temperature = main.temp ?: 0.0,
        pressure = main.pressure ?: 0,
        humidity = main.humidity ?: 0,
        windSpeed = wind.speed ?: 0.0,
        icon = weather.firstOrNull()?.icon ?: Constants.EMPTY_ICON
    )
}

data class WeatherDto(
    val description: String?,
    val icon: String?
)

data class MainDto(
    val temp: Double?,
    val pressure: Int?,
    val humidity: Int?
)

data class WindDto(
    val speed: Double?
)