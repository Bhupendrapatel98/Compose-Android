package com.app.firstcomposeapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    @Composable
    fun MyApp(){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "splash"){
            composable("splash"){
                SplashScreen(navController = navController)
            }
            composable("signin"){
                SignInScreen(navController = navController)
            }
            composable("otp"){
                OtpScreen(navController = navController)
            }
            composable("signup"){
                SignUpScreen(navController = navController)
            }
            composable("home"){
                DashboardScreen(this@MainActivity)
            }
            composable("detail"){
                KnowAboutPlantScreen(context = this@MainActivity)
            }
        }
    }
}