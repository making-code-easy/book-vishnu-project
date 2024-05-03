package com.example.myapplication2.domain.dataclass

import com.google.gson.annotations.SerializedName

data class Book(
    val title: String,
    val description:String,
    @SerializedName("book_image")
    val imageUrl:String
)