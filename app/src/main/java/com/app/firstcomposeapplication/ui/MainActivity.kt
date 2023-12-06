package com.app.firstcomposeapplication.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.app.firstcomposeapplication.R
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            initUi()

            LaunchedEffect(Unit){
                delay(3000)
                startActivity(Intent(this@MainActivity,SignUpActivity::class.java))
            }
        }
    }

    @Preview
    @Composable
    fun initUi() {
        Column(modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

            Image(painter = painterResource(id = R.drawable.thirdroc),
                contentDescription ="", modifier = Modifier.size(250.dp))
        }
    }
}