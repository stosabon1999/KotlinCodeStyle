package com.sobolevsky.kotlincodestyle.view.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sobolevsky.kotlincodestyle.domain.interactor.WeatherCityInteractor
import com.sobolevsky.kotlincodestyle.models.WeatherCityResponse
import com.sobolevsky.kotlincodestyle.models.domain.WeatherDomainItem
import com.sobolevsky.kotlincodestyle.view.binders.ItemViewType
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Вью модель для отображения погоды по городу
 *
 * @property weatherCityInteractor интерактор для поулчения погоды по городу
 */
internal class WeatherCityViewModel @Inject constructor() : ViewModel() {

    @Inject lateinit var weatherCityInteractor: WeatherCityInteractor

    private val _weatherData = MutableLiveData<List<ItemViewType>>()
    private val _isLoading = MutableLiveData<Boolean>()
    private val _serviceUnavailable = MutableLiveData<Unit>()

    /**
     * Данные по погоде.
     */
    val weatherData: LiveData<List<ItemViewType>>
        get() = _weatherData

    /**
     * Состояние загрузки.
     */
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    /**
     * Состояние ошибки.
     */
    val serviceUnavailable: LiveData<Unit>
        get() = _serviceUnavailable

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _serviceUnavailable.value = Unit
        _isLoading.value = false
    }

    /**
     * Загрузка погодных данных.
     */
    fun loadWeather() {
        _isLoading.value = true
        viewModelScope.launch(handler) {
            val data = withContext(Dispatchers.IO) {
                weatherCityInteractor.loadWeather()
            }
            _weatherData.value = data
            _isLoading.value = false
        }
    }
}