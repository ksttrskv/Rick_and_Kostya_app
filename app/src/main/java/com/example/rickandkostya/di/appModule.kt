package com.example.rickandkostya.di

import com.example.rickandkostya.Screens.mainScreen.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainScreenViewModel(
            getCharactersUseCase =get(),
            getLocationDetailsUseCase = get(),
            getEpisodeDetailsUseCase = get()
        )
    }
}