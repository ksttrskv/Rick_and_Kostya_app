package com.example.data.di.RickAndMortyApi

import com.example.data.di.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacters(): CharactersResponse


    @GET
    suspend fun getLocationByUrl(@Url url: String): Response<LocationDetails>

    @GET
    suspend fun getEpisodeByUrl(@Url url: String): Response<EpisodeDetails>
}

// Модели для локации и эпизода
data class LocationDetails(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String
)

data class EpisodeDetails(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String
)
