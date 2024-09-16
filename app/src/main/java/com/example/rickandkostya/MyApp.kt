package com.example.rickandkostya

import android.app.Application
import com.example.data.di.RickAndMortyApi.retrofitModule
import com.example.data.di.RickAndMortyApi.di.dataModule
import com.example.domain.di.domainModule
import com.example.rickandkostya.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Инициализация Koin
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(appModule, retrofitModule, dataModule, domainModule)
        }
    }
}

//val appModule = module {
//    viewModelOf (::MainScreenViewModel)
//}
