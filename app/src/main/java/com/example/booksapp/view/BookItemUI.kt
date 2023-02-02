
package com.example.booksapp.view
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.booksapp.DetailsActivity
import com.example.booksapp.model.Items

@Composable
fun BookItemUI(item: Items) {

    val author = item.volumeInfo?.authors?.first().toString()
    val imageURL = item.volumeInfo?.imageLinks?.smallThumbnail
    val context = LocalContext.current
    val onClick = {
        context.startActivity(Intent(context, DetailsActivity::class.java).apply {
            putExtra("bookDetails",item)
        })
    }
    val painter =
        rememberImagePainter(data = imageURL?.replace("http","https"))

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
                .size(128.dp)
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