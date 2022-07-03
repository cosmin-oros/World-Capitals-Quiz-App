package com.example.worldcapitalsquiz

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnrememberedMutableState")
@Composable
fun GameScreen(name: String?) {
    var textFieldState by remember{
        mutableStateOf("")
    }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    //get the list of countries and sort by the name of the capital
    val countriesList = ListOfCountries.getData()
    countriesList.sortedBy { country->
        country.capital
    }
    var counter = 0 //count until 195
    var country = mutableStateOf(countriesList.get(counter))
    //percentage of the circular progress bar
    var percentage = 0F

    var painter = painterResource(id = country.value.flagId)
    var countryName = country.value.country
    var capitalName = country.value.capital

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ){
                ImageCard(
                    painter = painter,
                    contentDescription = countryName,
                    title = countryName
                )
            }

            Spacer(modifier = Modifier.size(32.dp))

            OutlinedTextField(
                value = textFieldState,
                label = {
                    Text(text = "Enter the capital")
                },
                onValueChange = {
                    textFieldState = it
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.6f),
                textStyle = TextStyle(color = Color.LightGray, fontSize = 20.sp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                )

            )


        }
    }
    //add check and skip button
}