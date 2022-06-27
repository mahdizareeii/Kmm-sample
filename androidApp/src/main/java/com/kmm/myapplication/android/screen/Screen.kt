package com.kmm.myapplication.android.screen

sealed class Screen(
    val route: String,
    val argumentId: String
) {
    object AnimalsScreen : Screen(
        route = "animalsScreen",
        argumentId = "animalArgument"
    )

    object DetailScreen : Screen(
        route = "detailScreen",
        argumentId = "screenArgument"
    )
}