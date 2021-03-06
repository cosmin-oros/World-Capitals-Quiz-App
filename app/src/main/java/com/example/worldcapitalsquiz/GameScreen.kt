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
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

@SuppressLint("UnrememberedMutableState")
@Composable
fun GameScreen(navController: NavController, name: String?) {
    var textFieldState by remember{
        mutableStateOf("")
    }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val countriesList = ListOfCountries.getData().sortedBy { country->
        country.order
    }
    var counter = 0 //count until 195
    var guessed = 0
    var country = mutableStateOf(getCountry(countriesList, counter))
    //percentage of the circular progress bar
    var percentage = 0F
    val type: String
    if (name == "0") {
        type = "0"
    }else {
        type = "1"
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
    ) {
        Button(
            onClick = {

                navController.navigate(Screen.GameScreen.withArgs(type))
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.LightGray

            ),
            modifier = Modifier
                .padding(10.dp)
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
            Text(text = "Restart")
        }


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
                       if (counter < 192) {
                           if (textFieldState.lowercase(Locale.getDefault()) == capitalName.lowercase(
                                   Locale.getDefault()
                               )
                           ) {
                               counter++
                               country.value = getCountry(countriesList, counter)
                               guessed++
                               textFieldState = ""
                               percentage += 0.0052F
                           } else {
                               scope.launch {
                                   scaffoldState.snackbarHostState.showSnackbar("Try again")
                                   textFieldState = ""
                               }
                           }
                       }

                       if (counter == 192){
                           scope.launch {
                               scaffoldState.snackbarHostState.showSnackbar("Congratulations you got $guessed out of 193")
                               textFieldState = ""

                               delay(3000L)
                               navController.navigate("main_screen")
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

                /* has to be 192 else it would crash */
                Button(
                    onClick = {
                        if (counter < 192) {
                            counter++
                            country.value = getCountry(countriesList, counter)
                            textFieldState = ""
                        }

                        if (counter == 192){
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Congratulations you got $guessed out of 193")
                                textFieldState = ""

                                delay(3000L)
                                navController.navigate("main_screen")
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

            Spacer(modifier = Modifier.size(64.dp))

            Row {
                ExpandableCard(
                    title = "Hint",
                    description = hint
                )

                Spacer(modifier = Modifier.width(32.dp))

                CircularProgressBar(percentage = percentage, number = 193)

            }


        }

    }
}

fun getCountry(countriesList: List<CountriesData>, counter: Int): CountriesData{
    return countriesList[counter]
}