package com.app.firstcomposeapplication.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.firstcomposeapplication.R
import com.app.firstcomposeapplication.ui.ui.theme.FirstComposeApplicationTheme
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Init()
            LaunchedEffect(Unit){
                delay(3000)
                startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
            }
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
}
