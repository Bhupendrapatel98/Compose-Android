package com.app.firstcomposeapplication.ui

import android.app.LauncherActivity
import android.app.LauncherActivity.ListItem
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.firstcomposeapplication.R
import com.app.firstcomposeapplication.ui.ui.theme.FirstComposeApplicationTheme
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InitView()
        }
    }

    @Preview
    @Composable
    fun InitView() {

        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()){
            Image(painter = painterResource(id = R.drawable.app_bg), contentDescription ="" ,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(), contentScale = ContentScale.Crop)

            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                Row(modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(id = R.drawable.menu_icon), contentDescription ="",Modifier.size(30.dp) )
                        Text(text = "Hi Bhupendra,", color = Color.White, fontSize = 18.sp, fontFamily = FontFamily.SansSerif
                            , modifier = Modifier.padding(start = 15.dp), fontWeight = FontWeight.SemiBold)
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                        Image(painter = painterResource(id = R.drawable.notification), contentDescription = "", Modifier.size(25.dp))
                        Image(painter = painterResource(id = R.drawable.scanner_icon), contentDescription = "", Modifier.size(25.dp))
                    }
                }
                
                OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color.White,
                        focusedIndicatorColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp),
                placeholder = {
                    Row{
                        Image(painter = painterResource(id = R.drawable.search), contentDescription ="", modifier = Modifier.size(20.dp) )
                        Text(text = "Search", color = Color.White, fontSize = 14.sp, fontFamily = FontFamily.SansSerif)}
                    }
                 )
                
                Text(
                    text = "Know about plants",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 30.dp)
                )

                PlantRecyclerView()

                Text(
                    text = "Learn about plants",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 20.dp)
                )

                LearnPlantRecyView()

                Text(
                    text = "Popular plants",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 20.dp)
                )

                PopularPlantRecyView()
            }
        }
    }

    @Composable
    fun PopularPlantRecyView(){
        val items = mutableListOf<Drawable>()
        items.add(resources.getDrawable(R.drawable.popular_one))
        items.add(resources.getDrawable(R.drawable.popular_two))
        items.add(resources.getDrawable(R.drawable.item_img3))
        items.add(resources.getDrawable(R.drawable.item_img3))
        items.add(resources.getDrawable(R.drawable.item_img3))
        items.add(resources.getDrawable(R.drawable.item_img3))

        LazyRow(modifier = Modifier.padding(top = 10.dp)){
            items(items){
                PopularPlanItem(it)
            }
        }
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun PopularPlanItem(item:Drawable){
        Card(shape = RoundedCornerShape(8.dp), backgroundColor = Color.Gray,
            modifier = Modifier
                .width(170.dp)
                .height(180.dp)
                .padding(end = 10.dp)) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight().padding(5.dp),
            ) {
                GlideImage(model = item,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                )

                    Text(
                        text = "Yarrow",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                    )

                Text(
                    text = "Summer plant less water required for growth",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W400,
                )

            }
        }
    }

    @Composable
    fun LearnPlantRecyView(){
        val items = mutableListOf<Drawable>()
        items.add(resources.getDrawable(R.drawable.lear_one))
        items.add(resources.getDrawable(R.drawable.learn_two))
        items.add(resources.getDrawable(R.drawable.learn_three))
        items.add(resources.getDrawable(R.drawable.item_img3))
        items.add(resources.getDrawable(R.drawable.item_img3))
        items.add(resources.getDrawable(R.drawable.item_img3))

        LazyRow(modifier = Modifier.padding(top = 10.dp)){
            items(items){
                LearnListItem(it)
            }
        }
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun LearnListItem(item : Drawable){
        Card(shape = RoundedCornerShape(8.dp), backgroundColor = Color.Gray,
        modifier = Modifier
            .width(170.dp)
            .height(100.dp)
            .padding(end = 10.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
                ) {

                GlideImage(model = item,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(40.dp)
                        .fillMaxHeight())

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Coleus",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun PlantRecyclerView(){
        val items = mutableListOf<Drawable>()
        items.add(resources.getDrawable(R.drawable.item_img))
        items.add(resources.getDrawable(R.drawable.item_image2))
        items.add(resources.getDrawable(R.drawable.item_img3))
        items.add(resources.getDrawable(R.drawable.item_img))
        items.add(resources.getDrawable(R.drawable.item_image2))
        items.add(resources.getDrawable(R.drawable.item_img3))
        items.add(resources.getDrawable(R.drawable.item_img))
        items.add(resources.getDrawable(R.drawable.item_image2))
        items.add(resources.getDrawable(R.drawable.item_img3))


        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        ){
            items(items = items){item->
                ListItemCard(item)
            }
        }
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun ListItemCard(item: Drawable){
        Card( modifier = Modifier
            .height(110.dp)
            .width(120.dp)
            .padding(end = 8.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            GlideImage(model = item,
                contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier =Modifier.fillMaxSize())
        }
    }
}