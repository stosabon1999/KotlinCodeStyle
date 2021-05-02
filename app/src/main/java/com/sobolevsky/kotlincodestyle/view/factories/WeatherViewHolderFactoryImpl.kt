package com.sobolevsky.kotlincodestyle.view.factories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.sobolevsky.kotlincodestyle.R
import com.sobolevsky.kotlincodestyle.models.view.ItemType
import com.sobolevsky.kotlincodestyle.view.binders.ItemViewType
import com.sobolevsky.kotlincodestyle.view.payloads.WeatherPayload
import com.sobolevsky.kotlincodestyle.view.viewholders.BaseViewHolder
import com.sobolevsky.kotlincodestyle.view.viewholders.WeatherViewHolder

/**
 * Реализация для [WeatherViewHolderFactory].
 * Очевидно, что в данном кейсе фабрика избыточна, реализована для демонстрации ситуации с несколькими View-Holder'ами
 *
 * @author Соболевский Станислав
 */
internal class WeatherViewHolderFactoryImpl: WeatherViewHolderFactory {

    override fun createViewHolder(parent: ViewGroup, type: Int): BaseViewHolder<out ItemViewType, WeatherPayload> {
        val viewType = ItemType.values()[type]
        return when(viewType) {
            ItemType.CITY_WEATHER -> {
                WeatherViewHolder(parent.inflateView(R.layout.weather_city_item))
            }
        }
    }

    /**
     * инфлейтит вьюху с соответствующей разметкой
     *
     * @param layout layout-разметка
     */
    fun ViewGroup.inflateView(@LayoutRes layout: Int): View =
        LayoutInflater.from(context).inflate(layout, this, false)
}