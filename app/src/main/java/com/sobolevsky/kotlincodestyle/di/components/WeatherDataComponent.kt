package com.sobolevsky.kotlincodestyle.di.components

import com.sobolevsky.kotlincodestyle.domain.interactor.WeatherCityInteractor

/**
 * Компонент для получения зависимостей по работе с данными.
 *
 * @author Соболевский Станислав
 */
internal interface WeatherDataComponent {

    fun getInteractor(): WeatherCityInteractor
}