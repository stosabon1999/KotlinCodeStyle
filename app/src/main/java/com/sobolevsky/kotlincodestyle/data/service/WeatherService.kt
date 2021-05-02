package com.sobolevsky.kotlincodestyle.data.service

import com.sobolevsky.kotlincodestyle.models.WeatherCityResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

/**
 * Api для получения данных по погоде.
 * Неплохо бы было добавить выбор города, но пока хардкод Мюнхена
 *
 * @author Соболевский Станислав
 */
internal interface WeatherService {

    /**
     * Получение погоды за 5 дней с промежутком 3 часа в выбранном городе.
     */
    @GET("forecast?q=München,DE&appid=192e1608d962317dd464a1df6a312190")
    suspend fun getWeather(): WeatherCityResponse
}