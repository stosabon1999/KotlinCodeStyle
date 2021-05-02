package com.sobolevsky.kotlincodestyle.models.domain

/**
 * Domain сущность элемента с данными по погоде.
 *
 * @constructor
 * @param cityName название города
 * @param weatherList список с данными
 */
data class WeatherDomainItem(
    val cityName: String,
    val weatherList: List<WeatherDomainData>
)

/**
 * @constructor
 * @param date дата
 * @param temperature температура
 */
data class WeatherDomainData(
    val date: Int,
    val temperature: Float
)
