package com.ezgieren.weatherapp.presentation.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.ezgieren.weatherapp.domain.model.WeatherInfo
import com.ezgieren.weatherapp.util.Constants
import com.ezgieren.weatherapp.util.paddingNormal
import com.ezgieren.weatherapp.util.paddingNormal2x
import com.ezgieren.weatherapp.util.paddingSmall

@Composable
fun WeatherInfoCard(weatherInfo: WeatherInfo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .paddingNormal()
            .animateContentSize(),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(
            modifier = Modifier.paddingNormal2x(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // City Name
            Text(text = "${Constants.CITY_LABEL} ${weatherInfo.cityName}")

            // Temperature
            Text(
                text = "${Constants.WEATHER_TEMP} ${weatherInfo.temperature}${Constants.CELSIUS}",
                style = MaterialTheme.typography.bodyLarge
            )

            // Pressure
            Text(
                text = "${Constants.WEATHER_PRESSURE} ${weatherInfo.pressure} ${Constants.PRESSURE_UNIT}",
                style = MaterialTheme.typography.bodyLarge
            )

            // Humidity
            Text(
                text = "${Constants.WEATHER_HUMIDITY} ${weatherInfo.humidity}%",
                style = MaterialTheme.typography.bodyLarge
            )

            // Wind Speed
            Text(
                text = "${Constants.WEATHER_WIND_SPEED} ${weatherInfo.windSpeed} ${Constants.WIND_SPEED_UNIT}",
                style = MaterialTheme.typography.bodyLarge
            )

            val iconUrl = "${Constants.WEATHER_ICON_URL}${weatherInfo.icon}@2x.png"
            Image(
                painter = rememberImagePainter(iconUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .paddingSmall()  // paddingSmall extension using
            )
        }
    }
}