package com.example.domain

import com.example.data.di.CharacterRepository
import com.example.domain.Models.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository) {
    suspend fun execute(): List<Character> {
        return (characterRepository.getCharacters() ?: emptyList()) as List<Character>
    }
}