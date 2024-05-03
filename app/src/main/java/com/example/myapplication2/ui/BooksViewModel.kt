package com.example.myapplication2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication2.data.repository.ApiService
import com.example.myapplication2.data.repository.BooksRepository
import com.example.myapplication2.domain.dataclass.Book
import com.example.myapplication2.domain.usecase.BooksUseCase
import kotlinx.coroutines.launch

class BooksViewModel(private val useCase: BooksUseCase = BooksUseCase(BooksRepository(ApiService.service()))) :
    ViewModel() {

    private val _books: MutableLiveData<List<Book>> = MutableLiveData()
    val books: LiveData<List<Book>> = _books

    fun getBooks() {
        viewModelScope.launch {
            val res = useCase.getBooks()
            _books.value = res
        }
    }
}