package com.sobolevsky.kotlincodestyle.domain.interactor

import com.sobolevsky.kotlincodestyle.domain.repositories.WeatherCityRepository
import com.sobolevsky.kotlincodestyle.models.OneWayConverter
import com.sobolevsky.kotlincodestyle.models.WeatherCityResponse
import com.sobolevsky.kotlincodestyle.models.WeatherItem
import com.sobolevsky.kotlincodestyle.models.domain.WeatherDomainItem
import com.sobolevsky.kotlincodestyle.models.view.WeatherItemView
import com.sobolevsky.kotlincodestyle.view.binders.ItemViewType

internal class WeatherCityInteractorImpl(
    private val weatherCityRepository: WeatherCityRepository,
    private val converter: OneWayConverter<WeatherDomainItem, List<WeatherItemView>>
) : WeatherCityInteractor {

    override suspend fun loadWeather(): List<WeatherItemView> {
        return converter.convert(weatherCityRepository.loadWeather())
    }
}