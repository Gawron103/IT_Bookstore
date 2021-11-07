package com.example.it_bookstore.view_models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.it_bookstore.models.Book
import com.example.it_bookstore.models.BooksModel
import com.example.it_bookstore.repositories.BooksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class BooksViewModel(private val _repository: BooksRepository): ViewModel() {

    private val _mutableBooksData = MutableLiveData<List<Book>>()

    private val _loading = MutableLiveData<Boolean>()

    private var _job: Job? = null

    private val _TAG = "BooksViewModel"

    init {
        _fetchData()
    }

    fun getBooksLiveData() = _mutableBooksData as LiveData<List<Book>>
    fun getLoadingLiveData() = _loading as LiveData<Boolean>

    private fun _fetchData() {
        _job = viewModelScope.launch(Dispatchers.IO) {
            _loading.postValue(true)

            val response = _repository.getNewReleasesBooks()
            if (response.isSuccessful) {
                Log.d(_TAG, "Response good: $response")
                Log.d(_TAG, "Response body: ${response.body()}")
                val data = response.body()
                _mutableBooksData.postValue(data!!.books)
            }
            else {
                Log.d(_TAG, "Response bad: $response")
                _mutableBooksData.postValue(listOf())
            }

//            val booksMock = mutableListOf(
//                Book(
//                    "Designing Across Senses",
//                    "A Multimodal Approach to Product Design",
//                    "9781491954249",
//                    "$27.59",
//                    "https://itbook.store/img/books/9781491954249.png"
//                ),
//                Book(
//                    "Web Scraping with Python, 2nd Edition",
//                    "Collecting More Data from the Modern Web",
//                    "9781491985571",
//                    "$33.99",
//                    "https://itbook.store/img/books/9781491985571.png"
//                ),
//                Book(
//                    "Programming iOS 11",
//                    "Dive Deep into Views, View Controllers, and Frameworks",
//                    "9781491999226",
//                    "$59.17",
//                    "https://itbook.store/img/books/9781491999226.png",
//                ),
//                Book(
//                    "Designing Across Senses",
//                    "A Multimodal Approach to Product Design",
//                    "9781491954249",
//                    "$27.59",
//                    "https://itbook.store/img/books/9781491954249.png"
//                ),
//                Book(
//                    "Web Scraping with Python, 2nd Edition",
//                    "Collecting More Data from the Modern Web",
//                    "9781491985571",
//                    "$33.99",
//                    "https://itbook.store/img/books/9781491985571.png"
//                ),
//                Book(
//                    "Programming iOS 11",
//                    "Dive Deep into Views, View Controllers, and Frameworks",
//                    "9781491999226",
//                    "$59.17",
//                    "https://itbook.store/img/books/9781491999226.png",
//                ),
//                Book(
//                    "Designing Across Senses",
//                    "A Multimodal Approach to Product Design",
//                    "9781491954249",
//                    "$27.59",
//                    "https://itbook.store/img/books/9781491954249.png"
//                ),
//                Book(
//                    "Web Scraping with Python, 2nd Edition",
//                    "Collecting More Data from the Modern Web",
//                    "9781491985571",
//                    "$33.99",
//                    "https://itbook.store/img/books/9781491985571.png"
//                ),
//                Book(
//                    "Programming iOS 11",
//                    "Dive Deep into Views, View Controllers, and Frameworks",
//                    "9781491999226",
//                    "$59.17",
//                    "https://itbook.store/img/books/9781491999226.png",
//                )
//            )
//
//            _mutableBooksData.postValue(booksMock)

            _loading.postValue(false)
        }
    }

    override fun onCleared() {
        super.onCleared()
        _job?.cancel()
    }
}