package com.example.booksapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.booksapp.model.Items
import com.example.booksapp.searchBar.MainScreen
import com.example.booksapp.viewModel.SearchViewModel
import com.example.booksapp.ui.theme.BooksAppTheme
import com.example.booksapp.view.BookItemUI
import com.example.booksapp.viewModel.BookViewModel

class MainActivity : ComponentActivity() {

    private val booksViewModel by viewModels<BookViewModel>()
    private val mainViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchedEffect(key1 = Unit, block = {
                booksViewModel.getBookList()

            })
            BooksAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                        MainScreen(mainViewModel = mainViewModel,booksViewModel = booksViewModel )
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

