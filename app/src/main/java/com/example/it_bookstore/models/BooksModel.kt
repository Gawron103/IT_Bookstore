package com.example.it_bookstore.models

import com.google.gson.annotations.SerializedName

data class BooksModel (

 @SerializedName("books")
 val books: List<Book>

)