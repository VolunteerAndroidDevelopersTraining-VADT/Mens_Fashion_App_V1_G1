package com.example.mensfashion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.mensfashion.R
import com.example.mensfashion.core.ui.theme.MenFashionTheme
import com.example.mensfashion.favorite.presentation.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContent {
            MenFashionTheme {
                val navController = rememberNavController()
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}