package com.ezgieren.weatherapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezgieren.weatherapp.domain.model.WeatherInfo
import com.ezgieren.weatherapp.domain.use_case.GetWeatherByCityUseCase
import com.ezgieren.weatherapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherByCityUseCase: GetWeatherByCityUseCase  // inject UseCase
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherState())  // WeatherState initial value
    val state: StateFlow<WeatherState> = _state  // We only give read permission to the UI

    fun getWeather(cityName: String) {
        viewModelScope.launch {
            getWeatherByCityUseCase(cityName).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = WeatherState(weatherInfo = result.data)  // Data has arrived, UI will be updated
                    }
                    is Resource.Error -> {
                        _state.value = WeatherState(error = result.message ?: "Bir hata oluştu")  // Updating error message
                    }
                    is Resource.Loading -> {
                        _state.value = WeatherState(isLoading = true)  // Load status
                    }
                }
            }.launchIn(this)
        }
    }
}