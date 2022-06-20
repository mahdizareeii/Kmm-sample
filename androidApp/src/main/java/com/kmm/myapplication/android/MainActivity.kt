package com.kmm.myapplication.android

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.kmm.domain.viewmodel.AnimalListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<AnimalListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContent {
            AppTheme {

            }
        }*/
        viewModel.animals.onEach {
            it.mapIndexed { _, animal ->
                println("my_test : " + animal.name)
            }
        }.launchIn(lifecycleScope)
    }
}
