package com.sobolevsky.kotlincodestyle.view.binders

import com.sobolevsky.kotlincodestyle.models.view.ItemType

/**
 * Базовый интерфейс для элемента списка
 *
 * @author Соболевский Станислав.
 */
internal interface ItemViewType {

    val itemType: ItemType

    fun getUniqueId(): String

}