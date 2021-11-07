package com.example.it_bookstore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book (

    val title: String,

    val subtitle: String,

    val isbn: String,

    val price: String,

    val image: String,

): Parcelable