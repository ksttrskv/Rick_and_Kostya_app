package com.example.rickandkostya.core.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofitModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}


data class Timeouts(
    val call: Long = 120,
    val connect: Long = 5,
    val read: Long = 40,
    val write: Long = 15
)

fun getOkHttpClient(
    vararg interceptors: Interceptor,
    timeouts: Timeouts = Timeouts()
): OkHttpClient {
    // val loggingInterceptor = HttpLoggingInterceptor(ApiLogger()).apply {
    //     level = HttpLoggingInterceptor.Level.BODY
    // }

    return OkHttpClient()
        .newBuilder()
        .apply {
            interceptors.forEach {
                addInterceptor(it)
            }
            // if (BuildConfig.DEBUG) addInterceptor(loggingInterceptor)
            callTimeout(timeouts.call, TimeUnit.SECONDS)
            connectTimeout(timeouts.connect, TimeUnit.SECONDS)
            readTimeout(timeouts.read, TimeUnit.SECONDS)
            writeTimeout(timeouts.write, TimeUnit.SECONDS)
        }.build()
}