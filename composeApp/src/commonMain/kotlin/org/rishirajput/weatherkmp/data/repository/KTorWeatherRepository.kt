package org.rishirajput.weatherkmp.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import okio.IOException
import org.rishirajput.weatherkmp.data.api.KTorWeatherApi
import org.rishirajput.weatherkmp.domain.errors.InvalidCityException
import org.rishirajput.weatherkmp.domain.errors.NoNetworkException
import org.rishirajput.weatherkmp.domain.models.Location
import org.rishirajput.weatherkmp.domain.models.Result
import org.rishirajput.weatherkmp.domain.models.WeatherData
import org.rishirajput.weatherkmp.domain.repository.WeatherRepository

class KTorWeatherRepository(
    private val api: KTorWeatherApi,
    private val apiKey: String,
    private val debounceDelay: Long
) : WeatherRepository {

    override suspend fun getWeatherData(query: String): Result<List<WeatherData>> {
        if (query.isEmpty()) {
            return Result.Success(emptyList())
        }

        delay(debounceDelay)

        return withContext(Dispatchers.Default) {
            try {
                val locationsResult = getLocations(query)
                if (locationsResult is Result.Success) {
                    if (locationsResult.data.isEmpty()) {
                        return@withContext Result.Error(InvalidCityException())
                    }
                    val weatherData = locationsResult.data.map { location ->
                        val weatherResult = getWeatherDataForLocation(location.name)
                        if (weatherResult is Result.Success) {
                            weatherResult.data
                        } else {
                            return@withContext Result.Error((weatherResult as Result.Error).exception)
                        }
                    }
                    Result.Success(weatherData)
                } else {
                    Result.Error((locationsResult as Result.Error).exception)
                }
            } catch (e: IOException) {
                Result.Error(NoNetworkException())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }

    override suspend fun getLocations(query: String): Result<List<Location>> {
        return try {
            return api.searchLocation(apiKey, query)
//            Result.Success(result)
        } catch (e: IOException) {
            Result.Error(NoNetworkException())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getWeatherDataForLocation(locationName: String): Result<WeatherData> {
        return try {
            val result = api.getCurrentWeather(apiKey, locationName)
            if (result is Result.Success) {
                val current = result.data.current
                val weatherData = WeatherData(
                    locationName = locationName,
                    temperature = current.tempC,
                    condition = current.condition.text,
                    icon = current.condition.icon,
                    humidity = current.humidity,
                    uvIndex = current.uv,
                    feelsLike = current.feelsLikeC
                )
                return Result.Success(weatherData)
            }else {
                result as Result.Error
            }
        } catch (e: IOException) {
            Result.Error(NoNetworkException())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}