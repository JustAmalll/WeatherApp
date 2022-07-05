package dev.amal.weatherapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import dev.amal.weatherapp.data.mappers.toWeatherInfo
import dev.amal.weatherapp.data.remote.WeatherApi
import dev.amal.weatherapp.domain.repository.WeatherRepository
import dev.amal.weatherapp.domain.util.Resource
import dev.amal.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(
        lat: Double, long: Double
    ): Resource<WeatherInfo> = try {
        Resource.Success(
            data = api.getWeatherData(lat = lat, long = long).toWeatherInfo()
        )
    } catch (e: Exception) {
        e.printStackTrace()
        Resource.Error(e.message ?: "An unknown error occurred.")
    }

}