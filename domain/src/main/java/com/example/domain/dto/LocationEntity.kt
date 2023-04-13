package com.example.domain.dto

data class LocationEntity(
    val id: Int,
    val name: String,
    val residents: ArrayList<String>,
    )