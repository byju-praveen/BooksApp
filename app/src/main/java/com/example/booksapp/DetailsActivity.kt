package com.example.booksapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.booksapp.model.Items
import com.example.booksapp.ui.theme.BooksAppTheme

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val details = intent.getParcelableExtra<Items>("bookDetails")
        setContent {
            BooksAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BookDetailsUi(item = details)
                }
            }
        }
    }
}


@Composable
fun BookDetailsUi(item: Items?) {
    val imageURL =
        "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80"

    Card(
        elevation = 5.dp, modifier = Modifier
            .padding(16.dp)
            .padding(top = 10.dp)
            .border(
                2.dp, color = Color.Gray,
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxWidth()
    ) {
        val painter =
            rememberImagePainter(data = imageURL)

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Column() {
                Text(
                    text = item?.volumeInfo?.title ?: "",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .padding(14.dp)
                )
                Image(
                    painter = painter,
                    contentDescription = "Book Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    contentScale = ContentScale.FillBounds
                )
            }

            Text(
                text = "Description", fontSize = 25.sp, fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(4.dp)
            )
            LazyColumn() {
                item {
                    Text(
                        text = item?.volumeInfo?.description ?: "",
                        modifier = Modifier
                            .padding(20.dp)
                    )
                }
            }
        }
    }
}

