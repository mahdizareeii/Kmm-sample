package com.kmm.myapplication.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import com.kmm.domain.viewmodel.AnimalListViewModel
import com.kmm.myapplication.android.screen.AnimalListScreen
import com.kmm.myapplication.android.theme.AppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<AnimalListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AnimalListScreen(viewModel)
            }
        }
    }
}
