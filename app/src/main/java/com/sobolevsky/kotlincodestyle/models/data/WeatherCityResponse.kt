package com.sobolevsky.kotlincodestyle.models

import com.google.gson.annotations.SerializedName

/**
 * Серверная модель  с данными о погоде.
 */
data class WeatherCityResponse(
    val cod: String,
    val message: Float,
    val cnt: Int,
    val list: List<WeatherItem>,
    val city: City
)

data class WeatherItem(
    val dt: Int,
    val main: Main,
    val weather: List<Weather>,
    val clouds: Clouds,
    val wind: Wind,
    val rain: Rain,
    val sys: Sys,
    val dt_txt: String
)

data class Main(
    val temp: Float,
    val temp_min: Float,
    val temp_max: Float,
    val pressure: Float,
    val sea_level: Float,
    val grnd_level: Float,
    val humidity: Float,
    val temp_kf: Float
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class Clouds(
    val all: Int
)

data class Wind(
    val speed: Float,
    val deg: Float
)

data class Rain(
    @SerializedName("3h") val h: Float
)

data class Sys(
    val pod: String
)

data class City(
    val id: Int,
    val name: String,
    val coord: Coord,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Int,
    val sunset: Int
)

data class Coord(
    val lat: Float,
    val lon: Float
)