package com.example.booksapp.view

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.booksapp.DetailsActivity
import com.example.booksapp.model.Items

@Composable
fun BookItemUI(item: Items) {

    val author = item.volumeInfo?.authors?.first().toString()
    val imageURL = "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80"
    val context = LocalContext.current
    val onClick = {
        context.startActivity(Intent(context, DetailsActivity::class.java).apply {
            putExtra("bookDetails",item)
        })
    }
    val painter =
        rememberImagePainter(data = imageURL)

    Row(modifier = Modifier
        .padding(4.dp)
        .border(2.dp, Color.Black)
        .padding(4.dp)
        .clickable { onClick.invoke() }
    ) {
        Image(
            painter = painter,
            contentDescription = "Book Image",
            modifier = Modifier
                .size(180.dp)
                .align(alignment = Alignment.CenterVertically),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier
            .padding(4.dp)
            .weight(.4f)
            .padding(horizontal = 4.dp)

        ) {
            Text(
                text = item.volumeInfo?.title.toString(),
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = author,
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .background(
                        Color.LightGray
                    )
                    .padding(4.dp)
            )
            Text(
                text = item.volumeInfo?.publisher.toString(),
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = item.volumeInfo?.language .toString(),
                style = MaterialTheme.typography.body1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

        }


    }
}

