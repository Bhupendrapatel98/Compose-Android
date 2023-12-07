package com.app.firstcomposeapplication.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.firstcomposeapplication.R
import com.magneto.magotplib.Screen.OtpComposableFilled
import com.magneto.magotplib.Screen.OtpComposableOutlined

class OtpActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           InitView()
        }
    }

    @Preview
    @Composable
    fun InitView() {
        Box(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()) {

            Image(painter = painterResource(id = R.drawable.app_bg), contentDescription ="",
             contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight())
            
            Column(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(horizontal = 15.dp)) {
                
                Text(
                    text = "Sign In",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 26.sp,
                    modifier = Modifier.padding(top = 70.dp)
                )

                Text(
                 text = "Enter Otp",
                color = Color.White,
                fontWeight = FontWeight.W400,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 30.dp)
                )
                OtpComposableOutlined(
                    widthInDp = 50.dp,
                    heightInDp = 50.dp,
                    backgroundColor = Color.Transparent,
                    passwordToggle = true,
                    focusColor = Color.Blue,
                    unfocusColor = Color.Green,
                    cornerRadius = 8.dp,
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth(),
                    onvaluechange = {}
                )
                
                Text(
                    text = "Please type the verification code sent to Bhupendra.bp57@gmail.com",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 20.dp)
                )

                Button(onClick = {
                    startActivity(Intent(this@OtpActivity,DashboardActivity::class.java))
                },
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                  colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green
                ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Submit", color = Color.Black, fontSize = 18.sp)
                }



                Row(modifier = Modifier
                    .padding(top = 30.dp)
                    .align(alignment = Alignment.CenterHorizontally)) {
                    Text(text = "Not received the code yet ? ", color = Color.White, fontSize = 16.sp)
                    Text(text = "Resend", color = Color.Green, fontSize = 16.sp)
                }
            }
        }
    }
}
