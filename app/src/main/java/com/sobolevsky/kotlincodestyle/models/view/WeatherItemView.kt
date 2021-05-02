package com.sobolevsky.kotlincodestyle.models.view

import com.sobolevsky.kotlincodestyle.view.binders.ItemViewType

internal data class WeatherItemView(
    val title: String,
    val temperature: String,
    val date: String
) : ItemViewType {
    override val itemType: ItemType = ItemType.CITY_WEATHER
    override fun getUniqueId(): String = toString()
}