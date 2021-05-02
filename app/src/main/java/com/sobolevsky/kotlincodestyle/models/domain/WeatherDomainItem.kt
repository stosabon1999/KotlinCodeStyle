package com.sobolevsky.kotlincodestyle.models.domain

data class WeatherDomainItem(
    val cityName: String,
    val weatherList: List<WeatherDomainData>
)

data class WeatherDomainData(
    val date: Int,
    val temperature: Float
)
