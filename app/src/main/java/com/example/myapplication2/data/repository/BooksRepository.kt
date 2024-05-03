package com.example.myapplication2.data.repository

import com.example.myapplication2.domain.booksinterface.BooksInterface
import com.example.myapplication2.domain.dataclass.Book

open class BooksRepository(private val apiService: ApiService) : BooksInterface {
    override suspend fun getBooks(): List<Book> {
        val res = apiService.getBooks()
        return res.body()?.results?.books ?: mutableListOf()
    }
}