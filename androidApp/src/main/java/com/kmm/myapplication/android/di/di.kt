package com.kmm.myapplication.android.di

import com.kmm.myapplication.android.graph.NavGraph
import com.kmm.myapplication.android.screen.BaseScreen
import com.kmm.myapplication.android.screen.Screen
import com.kmm.myapplication.android.screen.animal.AnimalScreen
import com.kmm.myapplication.android.screen.detail.DetailScreen
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val screensModule = module {
    factory(named(Screen.AnimalsScreen.route)) {
        AnimalScreen(get())
    } bind BaseScreen::class

    factory(named(Screen.DetailScreen.route)) {
        DetailScreen()
    }

    factory {
        NavGraph(
            animalScreen = get(named(Screen.AnimalsScreen.route)),
            detailScreen = get(named(Screen.DetailScreen.route))
        )
    }
}