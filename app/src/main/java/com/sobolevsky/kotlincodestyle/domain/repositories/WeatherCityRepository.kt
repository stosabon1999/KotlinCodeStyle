package com.sobolevsky.kotlincodestyle.domain.repositories

import com.sobolevsky.kotlincodestyle.models.WeatherCityResponse
import com.sobolevsky.kotlincodestyle.models.domain.WeatherDomainItem

/**
 * Репозиторий для получения погоды по выбранному городу.
 *
 * @author Соболевский Станислав
 */
interface WeatherCityRepository {

    /**
     * Загрузка погоды по выбраннному городу.
     *
     * @return модель погоды
     */
    suspend fun loadWeather(): WeatherDomainItem
}