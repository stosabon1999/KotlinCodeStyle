package com.sobolevsky.kotlincodestyle.view.payloads

/**
 * Payload для вью погоды.
 *
 * @constructor
 * @param changeData изменились ли данные.
 *
 * @author Соболевский Станислав
 */
data class WeatherPayload(
    val changeData: Boolean = false
)