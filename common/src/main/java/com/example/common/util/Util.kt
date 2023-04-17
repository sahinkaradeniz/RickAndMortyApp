package com.example.common.util

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun extractIdsFromUrls(urls: List<String>): List<Int> {
    val ids = mutableListOf<Int>()
    for (url in urls) {
        val idString = url.substringAfterLast("/")
        val id = idString.toIntOrNull()
        if (id != null) {
            ids.add(id)
        }
    }
    return ids
}

@SuppressLint("NewApi")
fun formatDateTime(inputDateString: String): String {
    val formatter = DateTimeFormatter.ISO_DATE_TIME
    val inputDate = LocalDateTime.parse(inputDateString, formatter)
    val outputFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm", Locale.getDefault())
    return outputFormatter.format(inputDate)
}