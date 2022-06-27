package com.kmm.myapplication.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.kmm.myapplication.android.graph.NavGraph
import com.kmm.myapplication.android.theme.AppTheme
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val navGraph by inject<NavGraph>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                navGraph.createNavGraph()
            }
        }
    }
}
