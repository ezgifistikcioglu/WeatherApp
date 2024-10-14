package com.ezgieren.weatherapp.domain.repository

import com.ezgieren.weatherapp.domain.model.WeatherInfo
import com.ezgieren.weatherapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherByCity(cityName: String): Flow<Resource<WeatherInfo>>
}