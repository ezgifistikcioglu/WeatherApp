package com.ezgieren.weatherapp.presentation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ezgieren.weatherapp.presentation.viewmodel.WeatherViewModel
import com.ezgieren.weatherapp.util.Constants
import com.ezgieren.weatherapp.util.paddingNormal
import com.ezgieren.weatherapp.util.paddingNormal2x
import com.ezgieren.weatherapp.util.paddingSmall

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()  // Injecting ViewModel with Hilt
) {
    var city by remember { mutableStateOf(Constants.EMPTY) }  // keep the city name
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.paddingNormal2x(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TextField for the city name
        TextField(
            value = city,
            onValueChange = { city = it },
            label = { Text(Constants.ENTER_CITY) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    viewModel.getWeather(city)
                }
            )
        )

        Spacer(modifier = Modifier.paddingSmall())

        // Button to take weather data
        Button(
            onClick = { viewModel.getWeather(city) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(Constants.GET_WEATHER)
        }

        Spacer(modifier = Modifier.paddingNormal())

        // We determine how the screen behaves depending on the situation
        when {
            state.isLoading -> {
                CircularProgressIndicator()  // Loading state
            }
            state.weatherInfo != null -> {
                // Card for displaying weather information
                //WeatherInfoCard(state.weatherInfo!!)
            }
            state.error.isNotEmpty() -> {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}