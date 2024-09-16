package com.example.data.di

class EpisodeRepository(private val api: com.example.data.di.RickAndMortyApi.RickAndMortyApi) {

    suspend fun getEpisodeDetails(url: String): String? {
        return api.getEpisodeByUrl(url).body()?.name
    }
}