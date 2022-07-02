package com.example.worldcapitalsquiz

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun GameScreen(name: String?) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        if (name == "0"){
            //show names
        }else if (name == "1"){
            //don't show names
        }
    }
}