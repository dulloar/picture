package com.d.picture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.d.picture.data.network.model.Image
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity  : ComponentActivity() {
    private val imageViewModel: ViewModelImage  by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        imageViewModel.onCreate()

        imageViewModel.images.observe(this) { images ->

            setContent {

                Column() {

                    LazyRow {
                        item {
                            Box() {
                                Image(
                                    painter = painterResource(R.drawable.img),
                                    contentDescription = "avatar",
                                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                                    modifier = Modifier
                                        .size(64.dp)
                                        .clip(CircleShape)                       // clip to the circle shape
                                        .border(
                                            2.dp,
                                            Color.Gray,
                                            CircleShape
                                        )   // add a border (optional)
                                )
                                Icon(
                                    modifier = Modifier.size(size = 15.dp),
                                    imageVector = Icons.Default.AddCircle,
                                    tint = Color.Blue,
                                    contentDescription = "Person Icon"
                                )
                            }


                            Divider()
                        }

                        items(images!!.size) { image ->
                            Modifier.padding(14.dp)
                            imageHistory(image = images[image])
                        }

                    }
                    Divider()
                    LazyColumn {
                        item {
                            Image(
                                painter = painterResource(R.drawable.img),
                                contentDescription = "avatar",
                                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                                modifier = Modifier
                                    .size(464.dp)
                                    .clip(RoundedCornerShape(0.dp))                       // clip to the circle shape

                                    .padding(4.dp)// add a border (optional)
                            )
                            Divider()
                        }


                        //Genera
                        items(images!!.size) { image ->
                            imagePost(image = images[image])
                            Divider()
                        }
                    }
                }
            }

        }
    }


//Genera un componentes composeable usuando carrousel y recibiendo una lista de imagens del objeto Image
@Composable
fun Carrusel(image: Image) {
    LazyRow {
        item {
            Box() {
                Image(
                    painter = painterResource(R.drawable.img),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                        .border(2.dp, Color.Gray, CircleShape)   // add a border (optional)
                )
                Icon(
                    modifier = Modifier.size(size = 15.dp),
                    imageVector = Icons.Default.AddCircle,
                    tint = Color.Blue,
                    contentDescription = "Person Icon"
                )
            }
        }
    }
}
        @Composable
        fun Greeting(name: String) {
            Text(text = "Hello $name!")
        }

        @Composable
        fun imageHistory(image: Image) {
            Column() {


                AsyncImage(
                    ImageRequest.Builder(LocalContext.current)
                        .data(image.download_url)
                        .crossfade(true)
                        .build(),
                    contentDescription = image.author,
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                        .border(2.dp, Color.Gray, CircleShape)   // add a border (optional)
                )
                val padding = 16.dp
                Text(
                    text = image.author.split(" ")[0],
                    textAlign = TextAlign.Center,
                    modifier = Modifier.size(8.dp)
                )
                Spacer(Modifier.size(padding))

            }
            Modifier.padding(14.dp)

        }


        @Composable
        fun imagePost(image: Image) {

            Column() {

                AsyncImage(
                    ImageRequest.Builder(LocalContext.current)
                        .data(image.download_url)
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    contentDescription = image.author,
                    modifier = Modifier
                        .size(464.dp)
                        .clip(RoundedCornerShape(0.dp))
                )             // clip to the circle shape
                val padding = 16.dp
                Column {

                    Box{
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                            Row(verticalAlignment = Alignment.CenterVertically) {


                                Icon(
                                    modifier = Modifier.size(size = 15.dp),
                                    imageVector = Icons.Default.Favorite,
                                    tint = Color.Red,

                                    contentDescription = "Person Icon"


                                )
                                Icon(
                                    modifier = Modifier.size(size = 15.dp),
                                    imageVector = Icons.Default.Share,
                                    tint = Color.Red,

                                    contentDescription = "Person Icon"

                                )
                            }
                            Text(
                                text = "preuba",
                                textAlign = TextAlign.Center,
                                style = TextStyle(fontSize = 20.sp)
                            )
                        }
                    }

                    }

            }

        }

}
