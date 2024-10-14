package com.ezgieren.weatherapp.domain.model

data class WeatherInfo(
    val cityName: String,
    val description: String,
    val temperature: Double,
    val pressure: Int,
    val humidity: Int,
    val windSpeed: Double,
    val icon: String
)