package org.rishirajput.weatherkmp.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.rishirajput.weatherkmp.domain.models.WeatherData
import org.rishirajput.weatherkmp.domain.usecase.FetchWeatherDataUseCase
import org.rishirajput.weatherkmp.domain.usecase.GetCurrentWeatherDataUseCase
import org.rishirajput.weatherkmp.domain.usecase.GetStoredWeatherDataUseCase
import org.rishirajput.weatherkmp.domain.usecase.StoreWeatherDataUseCase
import org.rishirajput.weatherkmp.domain.models.Result

class WeatherViewModel(
    private val fetchWeatherDataUseCase: FetchWeatherDataUseCase,
    private val storeWeatherDataUseCase: StoreWeatherDataUseCase,
    private val getStoredWeatherDataUseCase: GetStoredWeatherDataUseCase,
    private val getCurrentWeatherDataUseCase: GetCurrentWeatherDataUseCase
) : ViewModel() {

    private val _searchResults = MutableStateFlow<List<WeatherData>>(emptyList())
    val searchResults: StateFlow<List<WeatherData>> = _searchResults

    private val _storedWeatherData = MutableStateFlow<WeatherData?>(null)
    val storedWeatherData: StateFlow<WeatherData?> = _storedWeatherData

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _errorFlow = MutableSharedFlow<Throwable>()
    val errorFlow: SharedFlow<Throwable> = _errorFlow

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private var fetchJob: Job? = null

    init {
        viewModelScope.launch {
            _storedWeatherData.value = getStoredWeatherDataUseCase()
            when (val result = getCurrentWeatherDataUseCase(_storedWeatherData.value)) {
                is Result.Success -> _storedWeatherData.value = result.data
                is Result.Error -> _errorFlow.emit(result.exception)
                null -> {
                    _errorFlow.emit(NullPointerException())
                }
            }
        }
    }

    fun fetchWeatherData(query: String) {
        _searchQuery.value = query
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = fetchWeatherDataUseCase(query)
                if (result is Result.Success) {
                    _searchResults.value = result.data
                } else if (result is Result.Error) {
                    _searchResults.value = emptyList()
                    _errorFlow.emit(result.exception)
                }
            } catch (e: Exception) {
                _searchResults.value = emptyList()
                _errorFlow.emit(e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun selectWeatherData(data: WeatherData) {
        viewModelScope.launch {
            storeWeatherDataUseCase(data)
            _storedWeatherData.value = data
            _searchQuery.value = ""
        }
    }
}