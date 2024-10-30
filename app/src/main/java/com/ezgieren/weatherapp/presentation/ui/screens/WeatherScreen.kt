package com.ezgieren.weatherapp.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ezgieren.weatherapp.presentation.ui.components.WeatherInfoCard
import com.ezgieren.weatherapp.presentation.viewmodel.WeatherViewModel
import com.ezgieren.weatherapp.util.Constants
import com.ezgieren.weatherapp.util.CustomButton
import com.ezgieren.weatherapp.util.CustomTextField
import com.ezgieren.weatherapp.util.paddingNormal2x

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    var city by remember { mutableStateOf("") }
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paddingNormal2x(),  // Padding extension
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTextField(
            value = city,
            onValueChange = { city = it },
            onSearch = { viewModel.getWeather(city) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        CustomButton(
            text = Constants.GET_WEATHER,
            onClick = { viewModel.getWeather(city) },
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(16.dp))

        when {
            state.isLoading -> {
                CircularProgressIndicator()  // Loading state
            }
            state.weatherInfo != null -> {
                WeatherInfoCard(state.weatherInfo!!)  // Weather Info Card
            }
            state.error.isNotEmpty() -> {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}