package com.app.firstcomposeapplication.ui

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.app.firstcomposeapplication.R
import com.app.firstcomposeapplication.ui.signIn.SignInViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun SignInScreen(navController: NavController,signInViewModel: SignInViewModel,context: Context) {
    Box(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(id = R.drawable.app_bg), contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {

            Text(
                text = "Sign In",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 26.sp,
                modifier = Modifier.padding(top = 70.dp)
            )

            Text(
                text = "Enter Email",
                color = Color.White,
                fontWeight = FontWeight.W400,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 30.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .height(50.dp)
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Enter Email",
                        color = Color.White,
                        modifier = Modifier
                            .height(50.dp)
                            .wrapContentHeight(Alignment.CenterVertically)
                    )
                }
            )

            Text(
                text = "Enter Password",
                color = Color.White,
                fontWeight = FontWeight.W400,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 20.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .height(50.dp)
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Enter Password",
                        color = Color.White,
                        modifier = Modifier
                            .height(50.dp)
                            .wrapContentHeight(Alignment.CenterVertically)
                    )
                }
            )

            Button(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green
                ), onClick = {
                    // navController.navigate("otp")
                    signInViewModel.callSignInApi()
                },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "sign In", color = Color.Black, fontSize = 18.sp)
            }

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(color = Color.White, thickness = 1.dp, modifier = Modifier.weight(1f))
                Text(
                    text = "Or", modifier = Modifier
                        .weight(0.3f)
                        .padding(horizontal = 10.dp), color = Color.White
                )
                Divider(color = Color.White, thickness = 1.dp, modifier = Modifier.weight(1f))
            }

            Text(
                text = "Sign up with",
                Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .weight(1f)
                        .size(30.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.fb_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .weight(1f)
                        .size(30.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.insta_logo),
                    contentDescription = "",
                    modifier = Modifier
                        .weight(1f)
                        .size(30.dp)
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(text = "Already have an account ? ", color = Color.White, fontSize = 16.sp)
                Text(text = "Sign in", color = Color.Green, fontSize = 16.sp)
            }
        }
    }

    callApi(signInViewModel,context)
}

@Composable
fun callApi(signInViewModel: SignInViewModel,context: Context) {
    val liveDataState = signInViewModel.liveData.observeAsState()
    val data = liveDataState.value

    Log.d("Datattata", "callApi: "+data)
}
