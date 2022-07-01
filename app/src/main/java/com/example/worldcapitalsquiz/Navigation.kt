package com.example.worldcapitalsquiz

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main_screen") {
        composable("game_screen") {
            GameScreen(navController = navController)
        }
        composable("main_screen") {
            MainScreen(navController = navController)
        }
    }
}