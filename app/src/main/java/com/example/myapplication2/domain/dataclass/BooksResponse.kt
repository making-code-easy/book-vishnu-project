package com.example.myapplication2.domain.dataclass

import com.google.gson.annotations.SerializedName

data class BooksResponse(
    @SerializedName("results")
    val results: Results
)