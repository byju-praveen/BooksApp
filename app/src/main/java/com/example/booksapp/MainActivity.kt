package com.example.booksapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.booksapp.model.Items
import com.example.booksapp.ui.theme.BooksAppTheme
import com.example.booksapp.view.BookItemUI
import com.example.booksapp.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {

    val booksViewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchedEffect(key1 = Unit, block = {
                booksViewModel.getMovieList()

            })
            BooksAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    BookList(bookList = booksViewModel.bookListResponse)
                }
            }
        }
    }
}

@Composable
fun BookList(bookList: List<Items>) {
    LazyColumn {
        itemsIndexed(items = bookList) { index, item ->
            BookItemUI(item = item)
        }
    }
}

