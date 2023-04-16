package com.example.data.dto.location

import com.google.gson.annotations.SerializedName

data class Results (
    @SerializedName("id"        ) var id        : Int,
    @SerializedName("name"      ) var name      : String,
    @SerializedName("type"      ) var type      : String,
    @SerializedName("dimension" ) var dimension : String,
    @SerializedName("residents" ) var residents : ArrayList<String>,
    @SerializedName("url"       ) var url       : String,
    @SerializedName("created"   ) var created   : String
)