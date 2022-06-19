package com.kmm.myapplication.android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.kmm.myapplication.viewmodel.AnimalListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val animalListViewModel by inject<AnimalListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv: TextView = findViewById(R.id.text_view)
        animalListViewModel.animals.onEach {
            it.forEach {
                tv.text = tv.text.toString() + "\n" + it.name
            }
        }.launchIn(lifecycleScope)

        animalListViewModel.error.mapNotNull { it }.onEach {
            tv.text = it
        }.launchIn(lifecycleScope)
    }
}
