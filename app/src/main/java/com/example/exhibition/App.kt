package com.example.exhibition

import android.app.Application
import com.example.exhibition.di.connectedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(connectedKoinModules)
        }
    }

}