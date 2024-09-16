package com.example.data.di

class LocationRepository(private val api: com.example.data.di.RickAndMortyApi.RickAndMortyApi) {

    suspend fun getLocationDetails(url: String): String? {
        return api.getLocationByUrl(url).body()?.name
    }
}