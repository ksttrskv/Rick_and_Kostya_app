package com.example.domain

import com.example.data.di.EpisodeRepository

class GetEpisodeDetailsUseCase(private val episodeRepository: EpisodeRepository) {

    suspend fun execute(url: String): String? {
        return episodeRepository.getEpisodeDetails(url)
    }
}