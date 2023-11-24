package com.app.firstcomposeapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.app.firstcomposeapplication.ui.theme.FirstComposeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            initUi()
        }
    }

    @Composable
    fun initUi() {
        Column {

            Row(
                Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Profile",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.W600,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Image(
                painter = painterResource(id = R.drawable.thirdroc), contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(150.dp),
                alignment = Alignment.Center
            )

            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                Text(
                    text = "Name",
                    fontSize = 20.sp
                )

                var text by remember { mutableStateOf("") }

                TextField(
                    value = text, onValueChange = {
                          text = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                        .border(
                            width = 0.5.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(8.dp),
                        ),

                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        containerColor = Color.White
                    ),
                    placeholder = { Text(text = "Enter Name")}
                )
                Text(
                    text = "Email",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )

                var email by remember { mutableStateOf("") }

                TextField(
                    value = email, onValueChange = {
                        email = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                        .border(
                            width = 0.5.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(8.dp),
                        ),

                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        containerColor = Color.White
                    ),
                    placeholder = { Text(text = "Enter Email")}
                )
                Text(
                    text = "Address",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )

                var address by remember { mutableStateOf("") }

                TextField(
                    value = address, onValueChange = {
                        address = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                        .border(
                            width = 0.5.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(8.dp),
                        ),

                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        containerColor = Color.White
                    ),
                    placeholder = { Text(text = "Enter Address")}
                )
                Text(
                    text = "Password",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )

                var password by remember { mutableStateOf("") }

                TextField(
                    value = password, onValueChange = {
                        password = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                        .border(
                            width = 0.5.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(8.dp),
                        ),

                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        containerColor = Color.White
                    ),
                    placeholder = { Text(text = "Enter Password")}
                )

                Button(onClick = {
                    Toast.makeText(this@MainActivity, "Hellooo", Toast.LENGTH_SHORT).show();
                },
                modifier = Modifier.padding(top = 20.dp).fillMaxWidth().align(Alignment.CenterHorizontally)) {
                    Text(text = "Submit", fontSize = 20.sp)
                }
            }
        }
    }
}