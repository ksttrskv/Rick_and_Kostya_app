package com.example.data.di.RickAndMortyApi.di

import com.example.data.di.CharacterRepository
import com.example.data.di.EpisodeRepository
import com.example.data.di.LocationRepository
import org.koin.dsl.module

val dataModule = module {
//        single { RickAndMortyApi(get()) }
        single { CharacterRepository(get()) }
        single { EpisodeRepository(get()) }
        single { LocationRepository(get()) }

}