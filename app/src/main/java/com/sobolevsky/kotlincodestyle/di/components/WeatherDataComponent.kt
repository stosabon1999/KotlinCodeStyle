package com.sobolevsky.kotlincodestyle.di.components

import com.sobolevsky.kotlincodestyle.domain.interactor.WeatherCityInteractor

internal interface WeatherDataComponent {

    fun getInteractor(): WeatherCityInteractor
}