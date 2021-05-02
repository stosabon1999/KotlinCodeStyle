package com.sobolevsky.kotlincodestyle.view.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sobolevsky.kotlincodestyle.view.binders.ItemViewType
import com.sobolevsky.kotlincodestyle.view.factories.WeatherViewHolderFactory
import com.sobolevsky.kotlincodestyle.view.payloads.WeatherPayload
import com.sobolevsky.kotlincodestyle.view.viewholders.BaseViewHolder

/**
 * Адаптер  с данными о погоде.
 *
 * @param viewHolderFactory фабрика вью холдеров
 *
 * @author Соболевский Станислав
 */
internal class WeatherAdapter(private val viewHolderFactory: WeatherViewHolderFactory)
    : BaseListAdapter<ItemViewType, WeatherPayload, BaseViewHolder<ItemViewType, WeatherPayload>>(WeatherDiffUtilCallback()) {

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemViewType, WeatherPayload> =
        viewHolderFactory.createViewHolder(parent, viewType) as BaseViewHolder<ItemViewType, WeatherPayload>

    override fun getItemViewType(position: Int): Int = getItem(position).itemType.viewType

    class WeatherDiffUtilCallback : DiffUtil.ItemCallback<ItemViewType>() {

        override fun areItemsTheSame(oldItem: ItemViewType, newItem: ItemViewType): Boolean =
            oldItem.itemType == newItem.itemType && oldItem.getUniqueId() == newItem.getUniqueId()

        override fun areContentsTheSame(oldItem: ItemViewType, newItem: ItemViewType): Boolean =
            oldItem == newItem

        override fun getChangePayload(oldItem: ItemViewType, newItem: ItemViewType): Any =
            WeatherPayload(oldItem.getUniqueId() == newItem.getUniqueId())
    }
}