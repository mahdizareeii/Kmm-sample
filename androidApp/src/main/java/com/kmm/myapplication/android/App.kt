package com.kmm.myapplication.android

import android.app.Application
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                com.kmm.core.di.coreModule
            )
        }
    }
}