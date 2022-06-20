package com.kmm.myapplication.android

import android.app.Application
import com.kmm.core.di.coreModule
import com.kmm.domain.di.androidAndroidModule
import com.kmm.domain.di.DDDModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                coreModule,
                *DDDModule,
                androidAndroidModule
            )
        }
    }
}