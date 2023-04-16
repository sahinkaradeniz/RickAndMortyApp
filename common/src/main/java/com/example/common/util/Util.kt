package com.example.common.util

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