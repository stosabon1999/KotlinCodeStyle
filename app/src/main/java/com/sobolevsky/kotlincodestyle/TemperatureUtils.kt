package com.sobolevsky.kotlincodestyle

/**
 * Преобразование градусов Кельвину в градусы по Цельсию
 */
fun Float.kelvinToCelsius(): String {
    return "${(this - 273.15).toInt()}º"
}