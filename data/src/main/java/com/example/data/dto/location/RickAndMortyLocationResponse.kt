package com.example.data.dto.location

import com.google.gson.annotations.SerializedName

/**
 * 546 -> 5 + 4 + 6 = 15
 * {1, 6, 7, 3, 2, 5, 9}
 * 1 + 9 = 7 + 3
 */
data class RickAndMortyLocationResponse(
    @SerializedName("info")
    var info: Info,
    @SerializedName("results")
    var results: ArrayList<Results>,
)