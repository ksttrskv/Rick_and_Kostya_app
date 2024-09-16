package com.example.rickandkostya.core.network

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create()) // replace kotlin serialization
            .build()
    }

}

// single {
//     val contentType = "application/json".toMediaType()
//     Retrofit.Builder()
//         .baseUrl("https://rickandmortyapi.com/api/")
//         .addConverterFactory(Json {
//             ignoreUnknownKeys = true
//             explicitNulls = false
//         }.asConverterFactory(contentType))
//         .build()
// }