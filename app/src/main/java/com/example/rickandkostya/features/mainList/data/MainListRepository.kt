package com.example.rickandkostya.features.mainList.data

import com.example.rickandkostya.core.network.ApiResult
import com.example.rickandkostya.core.network.toResultFlow
import com.example.rickandkostya.features.mainList.data.api.MainListApi
import com.example.rickandkostya.features.mainList.data.dto.CharacterApiResponse
import kotlinx.coroutines.flow.Flow

class MainListRepository(
    private val api: MainListApi
) {
    suspend fun getCharacters(): Flow<ApiResult<CharacterApiResponse?>> =
        toResultFlow { api.getCharacters() }
}

