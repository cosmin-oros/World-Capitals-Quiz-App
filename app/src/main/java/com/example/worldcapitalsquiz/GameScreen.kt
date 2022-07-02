package com.example.worldcapitalsquiz

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun GameScreen(name: String?) {
    var textFieldState by remember{
        mutableStateOf("")
    }
    //get the list of countries and sort by the name of the capital
    val countriesList = ListOfCountries.getData()
    countriesList.sortedBy { country->
        country.capital
    }
    //percentage of the circular progress bar
    var percentage = 0F

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