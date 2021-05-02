package com.sobolevsky.kotlincodestyle.view.factories

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sobolevsky.kotlincodestyle.view.binders.ItemViewType
import com.sobolevsky.kotlincodestyle.view.payloads.WeatherPayload
import com.sobolevsky.kotlincodestyle.view.viewholders.BaseViewHolder

/**
 * Фабрика для создания вью холдеров.
 *
 * @author Соболевский Станислав
 */
internal interface WeatherViewHolderFactory {

    /**
     * Создает [BaseViewHolder] для элемента
     *
     * @param parent   контейнер для элемента списка
     * @param viewType тип элемента
     * @return [BaseViewHolder] для отображения элемента
     */
    fun createViewHolder(parent: ViewGroup, type: Int) : BaseViewHolder<out ItemViewType, WeatherPayload>
}