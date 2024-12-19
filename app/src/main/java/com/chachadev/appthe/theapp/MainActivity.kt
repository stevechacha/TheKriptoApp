package com.chachadev.appthe.theapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.chachadev.appthe.theapp.bottomNav.StandardScaffold
import com.chachadev.appthe.theapp.navigation.AppNavigation
import com.chachadev.appthe.theapp.ui.theme.TheAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            TheAppTheme {
                StandardScaffold(
                    navController = navController,
                ){
                    AppNavigation(navController)
                }
            }
        }
    }
}


