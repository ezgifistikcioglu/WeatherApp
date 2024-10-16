package com.ezgieren.weatherapp.domain.use_case

import com.ezgieren.weatherapp.domain.model.WeatherInfo
import com.ezgieren.weatherapp.domain.repository.WeatherRepository
import com.ezgieren.weatherapp.util.Constants
import com.ezgieren.weatherapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class GetWeatherByCityUseCase @Inject constructor(
    private val repository: WeatherRepository
){
    //
    operator fun invoke(cityName: String) : Flow<Resource<WeatherInfo>>{
        if (cityName.isBlank()){
            return flowOf(Resource.Error(Constants.CITY_NAME))
        }
        return repository.getWeatherByCity(cityName)
    }
}