package com.example.it_bookstore.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BooksViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(BooksViewModel::class.java)) {
            BooksViewModel() as T
        }
        else {
            throw IllegalArgumentException("Unknown view model")
        }
    }
}