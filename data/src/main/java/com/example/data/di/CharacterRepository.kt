package com.example.data.di

import com.example.data.di.RickAndMortyApi.RickAndMortyApi

class CharacterRepository(private val api: RickAndMortyApi) {
    suspend fun getCharacters(): List<Character> {
        val response = api.getCharacters()
        // Логирование результата для отладки
        println("Response: $response")

        return (response.results ?: emptyList()) as List<Character> // Возвращаем пустой список, если results == null
    }
}