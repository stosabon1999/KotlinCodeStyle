package com.sobolevsky.kotlincodestyle.models

/**
 * Маппер из сущности [F] в сущность [T].
 *
 * @author Соболевский Станислав
 */
interface OneWayConverter<F, T> {
    /**
     * [F] -> [T]
     *
     * @param from from
     * @return to
     */
    fun convert(from: F): T
}