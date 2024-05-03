package com.example.myapplication2.domain.booksinterface

import com.example.myapplication2.domain.dataclass.Book

interface BooksInterface {

    suspend fun getBooks():List<Book>
}