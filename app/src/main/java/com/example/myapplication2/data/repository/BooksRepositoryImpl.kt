package com.example.myapplication2.data.repository

import com.example.myapplication2.data.services.ApiService
import com.example.myapplication2.domain.booksinterface.BooksRepository
import com.example.myapplication2.domain.dataclass.Book
import com.example.myapplication2.utils.BookAppConstant.ERROR_MESSAGE
import com.example.myapplication2.utils.BookAppConstant.HTTP_SUCCESS
import retrofit2.Response
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    BooksRepository {
    override suspend fun getBooks(): List<Book> {
        return processResponse(apiService.getBooks()).results.books
    }

    private fun <T> processResponse(apiResponse: Response<T>): T {
        if (apiResponse.code() == HTTP_SUCCESS) {
            return apiResponse.body() ?: throw Throwable(ERROR_MESSAGE)
        } else {
            throw Throwable(apiResponse.errorBody().toString())
        }
    }
}