package com.app.firstcomposeapplication.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.firstcomposeapplication.R
import kotlinx.coroutines.delay

    @Composable
    fun SplashScreen(navController: NavController){
        var navigateToHome  by remember { mutableStateOf(false) }
        Init()
        LaunchedEffect(Unit){
            delay(3000)
            navigateToHome = true
        }

        if (navigateToHome) {
            navController.navigate("signin")
        }
    }

    @Preview
    @Composable
    fun Init() {
        Column(modifier = Modifier
            .background(color = Color.Black)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

            Image(painter = painterResource(id = R.drawable.splash_logo), contentDescription ="",
            modifier = Modifier.size(130.dp))
        }
    }
