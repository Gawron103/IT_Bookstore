package com.example.it_bookstore.api

import com.example.it_bookstore.models.BooksModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BooksApi {

    @GET("/1.0/new")
    suspend fun getNewReleasesBooks(): Response<BooksModel>

    companion object {
        private val baseUrl = "https://api.itbook.store"
        private var _retrofit: BooksApi? = null

        fun getInstance(): BooksApi {
            if (null == _retrofit) {
                _retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .build()
                    .create(BooksApi::class.java)
            }

            return _retrofit!!
        }
    }

}