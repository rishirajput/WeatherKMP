package org.rishirajput.weatherkmp.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.utils.io.CancellationException
import co.touchlab.kermit.Logger
import org.rishirajput.weatherkmp.domain.models.Location
import org.rishirajput.weatherkmp.domain.models.WeatherResponse
import org.rishirajput.weatherkmp.domain.models.Result

class KTorWeatherApi(
    private val client: HttpClient,
    private val logger: Logger
) : WeatherApi {
    companion object {
        private const val BASE_URL = "https://api.weatherapi.com/v1"
    }

    override suspend fun getCurrentWeather(key: String, q: String): Result<WeatherResponse> {
        return try {
            logger.d { "Fetching current weather for $q" }
            val response: HttpResponse = client.get("$BASE_URL/current.json") {
                url {
                    parameters.append("key", key)
                    parameters.append("q", q)
                }
            }
            if (response.status == HttpStatusCode.OK) {
                val weatherResponse: WeatherResponse = response.body()
                logger.d { "Successfully fetched weather data for $q" }
                Result.Success(weatherResponse)
            } else {
                logger.e { "Error fetching weather data: ${response.status}" }
                Result.Error(Exception("Error: ${response.status}"))
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            logger.e { "Exception fetching weather data: ${e.message}" }
            Result.Error(e)
        }
    }

    override suspend fun searchLocation(key: String, q: String): Result<List<Location>> {
        return try {
            logger.d { "Searching location for $q" }
            val response: HttpResponse = client.get("$BASE_URL/search.json") {
                url {
                    parameters.append("key", key)
                    parameters.append("q", q)
                }
            }
            if (response.status == HttpStatusCode.OK) {
                val locations: List<Location> = response.body()
                logger.d { "Successfully fetched locations for $q" }
                Result.Success(locations)
            } else {
                logger.e { "Error fetching locations: ${response.status}" }
                Result.Error(Exception("Error: ${response.status}"))
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            logger.e { "Exception fetching locations: ${e.message}" }
            Result.Error(e)
        }
    }
}