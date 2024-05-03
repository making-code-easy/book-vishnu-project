package com.example.myapplication2.domain.usecase

import com.example.myapplication2.data.repository.BooksRepositoryImpl
import com.example.myapplication2.domain.dataclass.Book
import javax.inject.Inject

class BooksUseCase @Inject constructor(private val booksRepository: BooksRepositoryImpl) {
    suspend fun getBooks(): List<Book> {
        return booksRepository.getBooks()
    }
}