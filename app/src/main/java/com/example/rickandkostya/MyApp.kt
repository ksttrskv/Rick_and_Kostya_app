package com.example.rickandkostya

import android.app.Application
import com.example.rickandkostya.core.network.retrofitModule
import com.example.rickandkostya.features.mainList.di.mainListModule
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
            modules(
                retrofitModule,
                mainListModule
            )
        }
    }
}

//val appModule = module {
//    viewModelOf (::MainScreenViewModel)
//}
