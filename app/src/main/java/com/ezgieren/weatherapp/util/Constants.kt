package com.ezgieren.weatherapp.util

object Constants {
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    const val UNKNOWN_CITY = "Unknown City"
    const val UNKNOWN_TEXT = "Unknown"
    const val EMPTY_ICON = "01d"
    const val EMPTY = ""
    const val ERR_API = "API Error:"
    const val ERR_NETWORK = "Network Error: Please check your internet connection.:"
    const val CITY_NAME = "The city name is not empty!"

    // UI Strings
    const val ENTER_CITY = "Enter the city name"
    const val GET_WEATHER = "Get Weather"
    const val LOADING = "Loading the weather infos..."
    const val ERROR = "There was an error."
    const val NO_DATA = "No data available"
    const val CITY_LABEL = "City: "
    const val WEATHER_INFO = "Weather Information"
    const val WEATHER_TEMP = "Temperature: "
    const val WEATHER_PRESSURE = "Pressure: "
    const val WEATHER_HUMIDITY = "Humidity: "
    const val WEATHER_WIND_SPEED = "Wind Speed: "

    // Units
    const val CELSIUS = "°C"
    const val PRESSURE_UNIT = "hPa"
    const val WIND_SPEED_UNIT = "m/s"

    // Weather Icons
    const val WEATHER_ICON_URL = "https://openweathermap.org/img/wn/"
}