package com.example.myapplication2.domain.dataclass

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("books")
    val books: List<Book>,

    )