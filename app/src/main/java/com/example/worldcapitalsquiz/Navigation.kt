package com.example.worldcapitalsquiz

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.GameScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    //defaultValue
                    nullable = true
                }
            )
        ){ entry ->
            GameScreen(name = entry.arguments?.getString("name"))
        }
    }
}