package com.example.domain.di

import com.example.domain.GetCharactersUseCase
import com.example.domain.GetEpisodeDetailsUseCase
import com.example.domain.GetLocationDetailsUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModule = module {
    single { GetCharactersUseCase(get()) }
    single { GetLocationDetailsUseCase(get()) }
    single { GetEpisodeDetailsUseCase(get()) }
}
