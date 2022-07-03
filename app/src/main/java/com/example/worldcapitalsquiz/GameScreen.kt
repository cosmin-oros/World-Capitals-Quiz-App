package com.example.worldcapitalsquiz

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun GameScreen(name: String?) {
    var textFieldState by remember{
        mutableStateOf("")
    }
    val scaffoldState = rememberScaffoldState()

    //get the list of countries and sort by the name of the capital
    val countriesList = ListOfCountries.getData()
    countriesList.sortedBy { country->
        country.capital
    }
    //percentage of the circular progress bar
    var percentage = 0F
    var counter = 0 //count until 195

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {

    }
    //add check and skip button
}