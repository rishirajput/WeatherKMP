package org.rishirajput.weatherkmp.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.utils.io.CancellationException
import org.rishirajput.weatherkmp.domain.models.Location
import org.rishirajput.weatherkmp.domain.models.WeatherResponse

class KTorWeatherApi(private val client: HttpClient) : WeatherApi {
    companion object {
        private const val BASE_URL = "https://api.weatherapi.com/v1"
    }

    override suspend fun getCurrentWeather(key: String, q: String): Result<WeatherResponse> {
        return try {
            val response: HttpResponse = client.get("$BASE_URL/current.json") {
                url {
                    parameters.append("key", key)
                    parameters.append("q", q)
                }
            }
            if (response.status == HttpStatusCode.OK) {
                val weatherResponse: WeatherResponse = response.body()
                Result.success(weatherResponse)
            } else {
                Result.failure(Exception("Error: ${response.status}"))
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun searchLocation(key: String, q: String): Result<List<Location>> {
        return try {
            val response: HttpResponse = client.get("$BASE_URL/search.json") {
                url {
                    parameters.append("key", key)
                    parameters.append("q", q)
                }
            }
            if (response.status == HttpStatusCode.OK) {
                val locations: List<Location> = response.body()
                Result.success(locations)
            } else {
                Result.failure(Exception("Error: ${response.status}"))
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}