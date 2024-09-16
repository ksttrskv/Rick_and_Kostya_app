package com.example.rickandkostya.features.mainList.data.api

import com.example.rickandkostya.features.mainList.data.dto.CharacterApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface MainListApi {
    @GET("character")
    suspend fun getCharacters(): Response<CharacterApiResponse>
}