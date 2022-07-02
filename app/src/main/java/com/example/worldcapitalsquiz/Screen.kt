package com.example.worldcapitalsquiz

sealed class Screen(val route: String){
    object MainScreen: Screen("main_screen")
    object GameScreen: Screen("game_screen")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach { arg->
                append("/$arg")
            }
        }
    }
}
