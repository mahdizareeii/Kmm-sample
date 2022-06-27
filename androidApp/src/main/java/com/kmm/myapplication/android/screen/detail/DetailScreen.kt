package com.kmm.myapplication.android.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.kmm.myapplication.android.screen.BaseScreen
import com.kmm.myapplication.android.screen.Screen

class DetailScreen : BaseScreen {
    @Composable
    override fun createScreen(navController: NavController) {
        val argument = getArgument(navController)?.get<DetailScreenArgument>(
            Screen.DetailScreen.argumentId
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "${argument?.title}")
        }
    }
}