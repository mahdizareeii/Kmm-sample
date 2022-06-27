package com.kmm.myapplication.android.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController

interface BaseScreen {
    @Composable
    fun createScreen(navController: NavController)

    fun getArgument(
        navController: NavController
    ) = navController.previousBackStackEntry?.savedStateHandle

    fun putArgument(
        navController: NavController,
        savedStateHandle: SavedStateHandle.() -> Unit
    ) {
        navController.currentBackStackEntry?.savedStateHandle?.let {
            savedStateHandle.invoke(it)
        }
    }
}