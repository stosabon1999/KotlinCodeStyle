package com.sobolevsky.kotlincodestyle

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Получить отформатированную дату из [Int]
 */
fun Int.getDateTime(): String {
    val sdf = SimpleDateFormat("MM.dd.yyyy hh:mm", Locale.getDefault())
    val netDate = Date(this.toLong() * 1000)
    return sdf.format(netDate)
}