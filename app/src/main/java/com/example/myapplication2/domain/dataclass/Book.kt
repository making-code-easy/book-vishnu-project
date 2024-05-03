package com.example.myapplication2.domain.dataclass

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("book_image")
    val imageUrl: String
)