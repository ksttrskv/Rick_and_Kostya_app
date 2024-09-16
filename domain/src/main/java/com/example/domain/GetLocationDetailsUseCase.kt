package com.example.domain

import com.example.data.di.LocationRepository

class GetLocationDetailsUseCase(private val locationRepository: LocationRepository) {

    suspend fun execute(url: String): String? {
        return locationRepository.getLocationDetails(url)
    }
}