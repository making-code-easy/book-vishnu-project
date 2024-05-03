package com.example.myapplication2.domain.dataclass

data class BooksResponse(
    val copyright: String,
    val last_modified: String,
    val num_results: Int,
    val results: Results,
    val status: String
)