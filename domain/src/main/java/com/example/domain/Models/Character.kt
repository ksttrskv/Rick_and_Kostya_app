package com.example.domain.Models

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val location: Location,
    val image: String,
    val episode: List<String>
)

data class Location(
    val name: String,
    val url: String
)



