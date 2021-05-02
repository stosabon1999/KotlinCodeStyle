package com.sobolevsky.kotlincodestyle.domain.converters

import com.sobolevsky.kotlincodestyle.getDateTime
import com.sobolevsky.kotlincodestyle.kelvinToCelsius
import com.sobolevsky.kotlincodestyle.models.OneWayConverter
import com.sobolevsky.kotlincodestyle.models.domain.WeatherDomainItem
import com.sobolevsky.kotlincodestyle.models.view.WeatherItemView

/**
 * Конвертер данных по погоде domain -> view
 *
 * @author Соболевский Станислав
 */
internal class WeatherItemViewConverter : OneWayConverter<WeatherDomainItem, List<WeatherItemView>> {
    override fun convert(from: WeatherDomainItem): List<WeatherItemView> {
        return from.weatherList.map {
            WeatherItemView(
                from.cityName,
                it.temperature.kelvinToCelsius(),
                it.date.getDateTime()
            )
        }
    }
}