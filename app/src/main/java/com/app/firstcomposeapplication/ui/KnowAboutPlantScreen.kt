package com.app.firstcomposeapplication.ui

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.firstcomposeapplication.R
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KnowAboutPlantScreen(context: Context){

    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxHeight()
        .background(color = Color.Black)) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(290.dp)) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(245.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.knowaboutplant_bg),
                    contentDescription = "", contentScale = ContentScale.Crop, modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )

                Text(text = "Know about Plants", fontSize = 20.sp, color = Color.White
                , modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 35.dp), textAlign = TextAlign.Center)
            }

            Card(
                shape = RoundedCornerShape(8.dp), border = BorderStroke(1.dp, Color.White),
                modifier = Modifier.align(alignment = Alignment.BottomCenter)) {
                Image(
                    painter = painterResource(id = R.drawable.knowaboutplant_bg),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(100.dp)
                )
            }
        }
        
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 10.dp),
            text = "Ginkgo",
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W500
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 10.dp),
            text = "Ginkgo biloba",
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 10.dp, start = 15.dp, end = 15.dp),
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis dictum egestas dolor egestas. Netus pharetra, rhoncus tortor duis sit. In ipsum diam orci morbi ultricies massa amet. Aenean urna phasellus eget vestibulum, vulputate dui auctor sed est. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis dictum egestas dolor egestas. ",
            color = Color.White,
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Justify
        )

        Text(
            modifier = Modifier
                .align(alignment = Alignment.Start)
                .padding(top = 15.dp, start = 15.dp),
            text = "Pictures of Ginkgo",
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W500
        )

        GinkoPictureRecyView(context)
    }
}

@Composable
fun GinkoPictureRecyView(context:Context){
    val items = mutableListOf<Drawable>()
    items.add(context.resources.getDrawable(R.drawable.item_img))
    items.add(context.resources.getDrawable(R.drawable.item_image2))
    items.add(context.resources.getDrawable(R.drawable.item_img3))
    items.add(context.resources.getDrawable(R.drawable.item_img))

    LazyRow(modifier = Modifier.padding(top = 10.dp, start = 15.dp)){
        items(items){
            RecycleItem(it)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RecycleItem(drawable:Drawable){
    androidx.compose.material.Card(
        modifier = Modifier
            .height(110.dp)
            .width(120.dp)
            .padding(end = 8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        GlideImage(
            model = drawable,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}