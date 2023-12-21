package com.app.firstcomposeapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.firstcomposeapplication.ui.signIn.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val signInViewModel:SignInViewModel by viewModels()
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
                SignInScreen(navController = navController,signInViewModel,this@MainActivity)
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