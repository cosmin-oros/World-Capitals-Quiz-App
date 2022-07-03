package com.example.worldcapitalsquiz

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

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
    var guessed = 0
    var country = mutableStateOf(getCountry(countriesList, counter))
    //percentage of the circular progress bar
    var percentage = 0F

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var painter = painterResource(id = country.value.flagId)
            var countryName = country.value.country
            var capitalName = country.value.capital
            var hint = country.value.hint

            if (name == "0"){
                Text(text = countryName)
            }
            
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ){
                ImageCard(
                    painter = painter,
                    contentDescription = countryName
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

            Spacer(modifier = Modifier.size(32.dp))

            Row {
               Button(
                   onClick = {
                       if (textFieldState.lowercase(Locale.getDefault()) == capitalName.lowercase(Locale.getDefault())){
                           counter++
                           country.value = getCountry(countriesList, counter)
                           guessed++
                           textFieldState = ""
                           percentage += 0.005F
                           if (guessed == 194){
                               percentage = 1F
                           }
                       }else{
                           scope.launch {
                               scaffoldState.snackbarHostState.showSnackbar("Try again")
                               textFieldState = ""
                           }
                       }

                       if (counter == 194){
                           scope.launch {
                               scaffoldState.snackbarHostState.showSnackbar("Congratulations you got $guessed out of 195")
                               textFieldState = ""
                           }
                       }
                   },
                   colors = ButtonDefaults.buttonColors(
                       backgroundColor = Color.Transparent,
                       contentColor = Color.LightGray

                   ),
                   modifier = Modifier
                       .border(
                           width = 5.dp,
                           brush = Brush.horizontalGradient(
                               listOf(
                                   Color.Magenta,
                                   Color.Yellow
                               )
                           ),
                           shape = RoundedCornerShape(15.dp)
                       )
                       .width(100.dp)
                       .background(
                           Brush.horizontalGradient(
                               colors = listOf(
                                   Color.Transparent,
                                   Color.Transparent
                               ),
                               startX = 150f
                           )
                       )
               )
               {
                    Text(text = "Check")
               }

                Spacer(modifier = Modifier.width(32.dp))

                Button(
                    onClick = {
                        counter++
                        country.value = getCountry(countriesList, counter)
                        textFieldState = ""

                        if (counter == 194){
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Congratulations you got $guessed out of 195")
                                textFieldState = ""
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = Color.LightGray

                    ),
                    modifier = Modifier
                        .border(
                            width = 5.dp,
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color.Magenta,
                                    Color.Yellow
                                )
                            ),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .width(100.dp)
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Transparent
                                ),
                                startX = 150f
                            )
                        )
                )
                {
                    Text(text = "Skip")
                }
            }

            Spacer(modifier = Modifier.size(32.dp))

            Row {
                ExpandableCard(
                    title = "Hint",
                    description = hint
                )

                Spacer(modifier = Modifier.width(32.dp))



            }


        }
    }
    //add check and skip button
}

fun getCountry(countriesList: ArrayList<CountriesData>, counter: Int): CountriesData{
    return countriesList[counter]
}