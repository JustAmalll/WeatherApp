package dev.amal.weatherapp.domain.repository

import dev.amal.weatherapp.domain.util.Resource
import dev.amal.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}