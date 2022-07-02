package com.example.worldcapitalsquiz

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
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

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Welcome to the World Capitals Quiz!", fontSize = 20.sp, textAlign = TextAlign.Center,
                color = Color.Cyan, fontStyle = FontStyle.Italic, fontFamily = FontFamily.Monospace
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "Please select if you would like to have shown the name of the country or just the flag",
                fontSize = 20.sp, textAlign = TextAlign.Center, color = Color.Cyan, fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Monospace)

            Spacer(modifier = Modifier.height(64.dp))

            Row {
                Button(onClick = {
                    navController.navigate(Screen.GameScreen.withArgs("0"))
                },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = Color.LightGray

                    ),
                    modifier = Modifier
                        .border(
                            width = 5.dp,
                            brush = Brush.horizontalGradient(listOf(Color.Cyan, Color.Blue)),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .width(150.dp)
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Transparent
                                ),
                                startX = 150f
                            )
                        )
                ) {
                    Text(text = "SHOW NAMES", fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.width(32.dp))

                Button(onClick = {
                    navController.navigate(Screen.GameScreen.withArgs("1"))
                },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = Color.LightGray

                    ),
                    modifier = Modifier
                        .border(
                            width = 5.dp,
                            brush = Brush.horizontalGradient(listOf(Color.Cyan, Color.Blue)),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .width(150.dp)
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Transparent
                                ),
                                startX = 150f
                            )
                        )
                ) {
                    Text(text = "JUST FLAGS", fontSize = 14.sp)
                }
            }
        }
    }
}