package com.example.rickandkostya.features.mainList.domain

import com.example.rickandkostya.core.network.ApiResult
import com.example.rickandkostya.features.mainList.data.MainListRepository
import com.example.rickandkostya.features.mainList.data.dto.CharacterApiResponse
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCase(private val repo: MainListRepository) {
    suspend fun execute(): Flow<ApiResult<CharacterApiResponse?>> =
        repo.getCharacters()
}