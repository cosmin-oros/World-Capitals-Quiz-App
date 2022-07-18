package com.example.worldcapitalsquiz

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.compose.rememberNavController
import com.example.worldcapitalsquiz.ui.theme.WorldCapitalsQuizTheme
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorldCapitalsQuizTheme {
                MobileAds.initialize(this@MainActivity)

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        val isInEditMode = LocalInspectionMode.current
                        if (isInEditMode) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Red)
                                    .padding(horizontal = 2.dp, vertical = 6.dp),
                                textAlign = TextAlign.Center,
                                color = Color.White,
                                text = "Advert Here",
                            )
                        } else {
                            AndroidView(
                                modifier = Modifier.fillMaxWidth(0.25F),
                                factory = { context ->
                                    AdView(context).apply {
                                        setAdSize(AdSize.BANNER)
                                        adUnitId = "ca-app-pub-5116754338374159/4248596887"
                                        loadAd(AdRequest.Builder().build())
                                    }
                                }
                            )
                        }
                    }
                ){
                    Navigation()
                }
            }
        }
    }
}

