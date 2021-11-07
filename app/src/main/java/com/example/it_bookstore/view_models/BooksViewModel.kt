package com.example.it_bookstore.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.it_bookstore.models.Book

class BooksViewModel: ViewModel() {

    private val _mutableBooksData = MutableLiveData<List<Book>>()

    init {
        _fetchData()
    }

    fun getBooksLiveData() = _mutableBooksData

    private fun _fetchData() {
        val booksMock = mutableListOf(
            Book(
                "Designing Across Senses",
                "A Multimodal Approach to Product Design",
                "9781491954249",
                "$27.59",
                "https://itbook.store/img/books/9781491954249.png"
            ),
            Book(
                "Web Scraping with Python, 2nd Edition",
                "Collecting More Data from the Modern Web",
                "9781491985571",
                "$33.99",
                "https://itbook.store/img/books/9781491985571.png"
            ),
            Book(
                "Programming iOS 11",
                "Dive Deep into Views, View Controllers, and Frameworks",
                "9781491999226",
                "$59.17",
                "https://itbook.store/img/books/9781491999226.png",
            ),
            Book(
                "Designing Across Senses",
                "A Multimodal Approach to Product Design",
                "9781491954249",
                "$27.59",
                "https://itbook.store/img/books/9781491954249.png"
            ),
            Book(
                "Web Scraping with Python, 2nd Edition",
                "Collecting More Data from the Modern Web",
                "9781491985571",
                "$33.99",
                "https://itbook.store/img/books/9781491985571.png"
            ),
            Book(
                "Programming iOS 11",
                "Dive Deep into Views, View Controllers, and Frameworks",
                "9781491999226",
                "$59.17",
                "https://itbook.store/img/books/9781491999226.png",
            ),
            Book(
                "Designing Across Senses",
                "A Multimodal Approach to Product Design",
                "9781491954249",
                "$27.59",
                "https://itbook.store/img/books/9781491954249.png"
            ),
            Book(
                "Web Scraping with Python, 2nd Edition",
                "Collecting More Data from the Modern Web",
                "9781491985571",
                "$33.99",
                "https://itbook.store/img/books/9781491985571.png"
            ),
            Book(
                "Programming iOS 11",
                "Dive Deep into Views, View Controllers, and Frameworks",
                "9781491999226",
                "$59.17",
                "https://itbook.store/img/books/9781491999226.png",
            )
        )

        _mutableBooksData.value = booksMock
    }

}