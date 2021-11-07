package com.example.it_bookstore.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.it_bookstore.api.BooksApi
import com.example.it_bookstore.repositories.BooksRepository

class BooksViewModelFactory(private val repository: BooksRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(BooksViewModel::class.java)) {
            BooksViewModel(repository) as T
        }
        else {
            throw IllegalArgumentException("Unknown view model")
        }
    }
}