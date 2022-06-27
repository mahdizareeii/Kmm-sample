package com.kmm.myapplication.android

import android.app.Application
import com.kmm.domain.di.domainAndroidModule
import com.kmm.domain.di.DDDModule
import com.kmm.myapplication.android.di.screensModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                *DDDModule,
                domainAndroidModule,
                screensModule
            )
        }
    }
}