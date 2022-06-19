package com.kmm.myapplication.android

import android.app.Application
import com.kmm.myapplication.di.commonDi
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                commonDi
            )
        }
    }
}