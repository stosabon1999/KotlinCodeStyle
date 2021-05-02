package com.sobolevsky.kotlincodestyle.view.adapters

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sobolevsky.kotlincodestyle.view.binders.ItemViewType
import com.sobolevsky.kotlincodestyle.view.viewholders.BaseViewHolder

/**
 * Базовая реализация [ListAdapter].
 *
 * @param Payload - payload для [BaseViewHolder].
 * @param ViewModel - viewModel для [BaseViewHolder.bind].
 * @param ViewHolder - наследник [BaseViewHolder].
 * @constructor
 * @param diffCallback - реализация [DiffUtil.ItemCallback] с учетом типа [ViewModel].
 *
 */
internal abstract class BaseListAdapter<ViewModel : ItemViewType, Payload : Any, ViewHolder : BaseViewHolder<ViewModel, Payload>>(
    diffCallback: DiffUtil.ItemCallback<ViewModel>
) : ListAdapter<ViewModel, ViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = getItem(position).let(holder::bind)

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        return if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            holder.update(getItem(position), payloads.lastOrNull() as? Payload)
        }
    }

}