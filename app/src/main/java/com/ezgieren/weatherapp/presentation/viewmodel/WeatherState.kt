package com.ezgieren.weatherapp.presentation.viewmodel

import com.ezgieren.weatherapp.domain.model.WeatherInfo

data class WeatherState(
    val isLoading: Boolean = false, // Tracks whether the data has been loaded
    val weatherInfo: WeatherInfo? = null,  // Weather info data
    val error: String = ""  // Error Message
)
