package com.example.rickandkostya.features.mainList.di

import com.example.rickandkostya.features.mainList.data.MainListRepository
import com.example.rickandkostya.features.mainList.data.api.MainListApi
import com.example.rickandkostya.features.mainList.domain.GetCharactersUseCase
import com.example.rickandkostya.features.mainList.presentation.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val mainListModule = module {
    single { get<Retrofit>().create(MainListApi::class.java) }
    single { MainListRepository(get()) }
    single { GetCharactersUseCase(get()) }
    viewModel {
        MainScreenViewModel(
            getCharactersUseCase =get()
        )
    }
}