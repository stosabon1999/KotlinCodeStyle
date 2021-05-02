package com.sobolevsky.kotlincodestyle.domain.interactor

import com.sobolevsky.kotlincodestyle.models.WeatherCityResponse
import com.sobolevsky.kotlincodestyle.models.WeatherItem
import com.sobolevsky.kotlincodestyle.models.domain.WeatherDomainItem
import com.sobolevsky.kotlincodestyle.view.binders.ItemViewType

/**
 * Интерактор для получения погоды по выбранному городу.
 *
 * @author Соболевский Станислав
 */
internal interface WeatherCityInteractor {

    /**
     * Загрузка погоды по выбраннному городу.
     *
     * @return модель погоды для отображения
     */
    suspend fun loadWeather(): List<ItemViewType>
}