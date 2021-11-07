package com.example.it_bookstore.repositories

import com.example.it_bookstore.api.BooksApi

class BooksRepository(private val _booksService: BooksApi) {

    suspend fun getNewReleasesBooks() = _booksService.getNewReleasesBooks()

}