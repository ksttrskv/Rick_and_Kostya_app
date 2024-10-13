package com.example.rickandkostya.core.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit

val contentType = "application/json".toMediaType()

private val json = Json {
    ignoreUnknownKeys = true
    explicitNulls = false
}

val retrofitModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build())
            .addConverterFactory(
                json.asConverterFactory(contentType)
            )
            .build()
    }

}

val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}