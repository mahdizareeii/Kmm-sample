package com.kmm.myapplication.android.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kmm.myapplication.android.screen.BaseScreen
import com.kmm.myapplication.android.screen.Screen
import com.kmm.myapplication.android.screen.detail.DetailScreen

class NavGraph(
    private val animalScreen: BaseScreen,
    private val detailScreen: DetailScreen
) {

    @Composable
    fun createNavGraph(navController: NavHostController = rememberNavController()) {
        NavHost(navController = navController, startDestination = Screen.AnimalsScreen.route) {
            composable(
                route = Screen.AnimalsScreen.route
            ) {
                animalScreen.createScreen(navController)
            }

            composable(
                route = Screen.DetailScreen.route,
            ) {
                detailScreen.createScreen(navController)
            }
        }
    }

}