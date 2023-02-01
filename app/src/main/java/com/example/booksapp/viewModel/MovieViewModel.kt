package com.example.booksapp.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksapp.model.Items
import com.example.booksapp.network.ApiService
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    var bookListResponse:List<Items> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val response = apiService.getMovies("flower","1")
                Log.d("Hello","world")
                bookListResponse = response.items
            }
            catch (e: Exception) {
//                errorMessage = e.message.toString()
            }
        }
    }
}