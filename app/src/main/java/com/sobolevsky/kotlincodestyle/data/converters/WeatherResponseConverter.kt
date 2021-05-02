package com.sobolevsky.kotlincodestyle.data.converters

import com.sobolevsky.kotlincodestyle.models.OneWayConverter
import com.sobolevsky.kotlincodestyle.models.WeatherCityResponse
import com.sobolevsky.kotlincodestyle.models.domain.WeatherDomainData
import com.sobolevsky.kotlincodestyle.models.domain.WeatherDomainItem

/**
 * Конвертер данных по погоде data -> domain
 *
 * @author Соболевский Станислав
 */
class WeatherResponseConverter: OneWayConverter<WeatherCityResponse, WeatherDomainItem> {
    override fun convert(from: WeatherCityResponse): WeatherDomainItem {
        val weatherDomainList = from.list.map {
            WeatherDomainData(it.dt, it.main.temp)
        }
        return WeatherDomainItem(from.city.name, weatherDomainList)
    }
}