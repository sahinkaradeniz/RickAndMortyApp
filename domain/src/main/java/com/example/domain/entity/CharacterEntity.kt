package com.example.domain.entity

data class CharacterEntity(
    var id: Int,
    var name: String,
    var status: String,
    var species: String,
    var type: String,
    var gender: String,
    var image: String,
    var created: String,
    var origin:String,
    var location:String,
    val episodes:String
)