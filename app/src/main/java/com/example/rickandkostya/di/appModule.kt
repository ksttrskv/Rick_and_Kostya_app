package com.example.rickandkostya.di

import com.example.rickandkostya.features.mainList.presentation.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainScreenViewModel(
            getCharactersUseCase =get()
        )
    }
}