package com.example.myapplication2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication2.domain.dataclass.Book
import com.example.myapplication2.domain.usecase.BooksUseCase
import com.example.myapplication2.ui.uistate.UIState
import com.example.myapplication2.utils.BookAppConstant
import kotlinx.coroutines.launch
import javax.inject.Inject

class BooksViewModel @Inject constructor(private val useCase: BooksUseCase) :
    ViewModel() {

    private val _books: MutableLiveData<UIState<List<Book>>> = MutableLiveData()
    val books: LiveData<UIState<List<Book>>> = _books

    fun getBooks() {
        viewModelScope.launch {
            _books.value = UIState.Loading
            try {
                val res = useCase.getBooks()
                _books.value = UIState.Success(res)
            } catch (e: Exception) {
                _books.value = UIState.Fail(Throwable(BookAppConstant.ERROR_MESSAGE))
            }
        }
    }
}