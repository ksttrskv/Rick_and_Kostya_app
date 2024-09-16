package com.example.rickandkostya.features.mainList.data.dto

data class InfoResponse(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

data class OriginResponse(
    val name: String,
    val url: String
)

data class LocationResponse(
    val name: String,
    val url: String
)

data class CharacterResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginResponse,
    val location: LocationResponse,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)

data class CharacterApiResponse(
    val info: InfoResponse,
    val results: List<CharacterResponse>
)