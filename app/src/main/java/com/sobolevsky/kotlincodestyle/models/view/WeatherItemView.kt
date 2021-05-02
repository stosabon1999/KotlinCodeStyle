package com.sobolevsky.kotlincodestyle.models.view

import com.sobolevsky.kotlincodestyle.view.binders.ItemViewType

/**
 * Модель view для отображения данных о погоде.
 *
 * @constructor
 * @param title заголовок
 * @param temperature температура
 * @param date дата
 *
 * @author Соболевский Станислав
 */
internal data class WeatherItemView(
    val title: String,
    val temperature: String,
    val date: String
) : ItemViewType {
    override val itemType: ItemType = ItemType.CITY_WEATHER
    override fun getUniqueId(): String = toString()
}