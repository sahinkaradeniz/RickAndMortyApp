package com.example.data.dto.character

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name") var name: String,
    @SerializedName("url") var url: String,
)