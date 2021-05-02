package com.sobolevsky.kotlincodestyle.view.viewholders

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView
import com.sobolevsky.kotlincodestyle.view.binders.ItemViewType

internal abstract class BaseViewHolder<ViewModel : ItemViewType, Payload : Any>(
    view: View
) : RecyclerView.ViewHolder(view) {

    /**
     * Связывает [viewModel] и [itemView] между собой.
     */
    abstract fun bind(viewModel: ViewModel)

    /**
     * Связывает [itemView] с учетом разницы [payload] для [viewModel].
     */
    abstract fun bind(viewModel: ViewModel, payload: Payload)

    /**
     * Обновляет [itemView] с учетом разницы [payload] для [viewModel] в [update].
     * Или если [payload] == null обновляет всю [itemView] с помощью [bind].
     */
    open fun update(viewModel: ViewModel, payload: Payload?) {
        payload ?: return bind(viewModel)
        bind(viewModel, payload)
    }

}
