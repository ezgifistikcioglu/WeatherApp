package com.ezgieren.weatherapp.data.repository

import com.ezgieren.weatherapp.BuildConfig
import com.ezgieren.weatherapp.data.remote.api.WeatherApi
import com.ezgieren.weatherapp.data.remote.dto.toWeatherInfo
import com.ezgieren.weatherapp.domain.model.WeatherInfo
import com.ezgieren.weatherapp.domain.repository.WeatherRepository
import com.ezgieren.weatherapp.util.Constants
import com.ezgieren.weatherapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override fun getWeatherByCity(cityName: String): Flow<Resource<WeatherInfo>> = flow {
        emit(Resource.Loading())

        try {
            val response = api.getWeatherByCity(cityName, BuildConfig.WEATHER_API_KEY)
            val weatherInfo = response.toWeatherInfo()
            emit(Resource.Success(weatherInfo))
        } catch (e: HttpException) {
            emit(Resource.Error("${Constants.ERR_API} ${e.message()}"))
        } catch (e: IOException) {
            emit(Resource.Error(Constants.ERR_NETWORK))
        } catch (e: Exception) {
            emit(Resource.Error(Constants.UNKNOWN_TEXT))
        }
    }
}