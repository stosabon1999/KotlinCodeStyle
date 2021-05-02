package com.sobolevsky.kotlincodestyle.data.repositories

import com.sobolevsky.kotlincodestyle.data.service.WeatherService
import com.sobolevsky.kotlincodestyle.domain.repositories.WeatherCityRepository
import com.sobolevsky.kotlincodestyle.models.OneWayConverter
import com.sobolevsky.kotlincodestyle.models.WeatherCityResponse
import com.sobolevsky.kotlincodestyle.models.domain.WeatherDomainItem

/**
 * Реализация [WeatherCityRepository]
 *
 * @author Соболевский Станислав
 */
internal class WeatherCityRepositoryImpl(
    private val service: WeatherService,
    private val converter: OneWayConverter<WeatherCityResponse, WeatherDomainItem>
    ) : WeatherCityRepository {

    override suspend fun loadWeather(): WeatherDomainItem {
        return converter.convert(service.getWeather())
    }
}