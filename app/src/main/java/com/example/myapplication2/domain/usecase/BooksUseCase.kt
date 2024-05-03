package com.example.myapplication2.domain.usecase

import com.example.myapplication2.data.repository.BooksRepository
import com.example.myapplication2.domain.booksinterface.BooksInterface
import com.example.myapplication2.domain.dataclass.Book

class BooksUseCase(private val booksInterface: BooksRepository) {

    suspend fun getBooks():List<Book>{
        return booksInterface.getBooks()
    }
}