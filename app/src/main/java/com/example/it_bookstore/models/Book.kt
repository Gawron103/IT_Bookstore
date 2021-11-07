package com.example.it_bookstore.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(

    @SerializedName("title")
    val title: String,

    @SerializedName("subtitle")
    val subtitle: String,

    @SerializedName("isbn13")
    val isbn: String,

    @SerializedName("price")
    val price: String,

    @SerializedName("image")
    val image: String

): Parcelable