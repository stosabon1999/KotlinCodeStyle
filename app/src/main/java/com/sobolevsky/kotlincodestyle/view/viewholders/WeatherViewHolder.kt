package com.sobolevsky.kotlincodestyle.view.viewholders

import android.view.View
import android.widget.TextView
import com.sobolevsky.kotlincodestyle.R
import com.sobolevsky.kotlincodestyle.models.view.WeatherItemView
import com.sobolevsky.kotlincodestyle.view.payloads.WeatherPayload

/**
 * Вью холдер для отображения данных по погоде.
 */
internal class WeatherViewHolder(
    view: View
) : BaseViewHolder<WeatherItemView, WeatherPayload>(view) {

    private val title: TextView = itemView.findViewById(R.id.title)
    private val temperature: TextView = itemView.findViewById(R.id.temperature)
    private val date: TextView = itemView.findViewById(R.id.date)

    override fun bind(viewModel: WeatherItemView) {
        title.text = viewModel.title
        temperature.text = viewModel.temperature
        date.text = viewModel.date
    }

    override fun bind(viewModel: WeatherItemView, payload: WeatherPayload) {
        if (payload.changeData) {
            title.text = viewModel.title
            date.text = viewModel.date
            temperature.text = viewModel.temperature
        }
    }
}