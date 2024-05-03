package com.example.myapplication2.ui.uistate

sealed class UIState<out T : Any> {
    data class Success<out T : Any>(val data: T) : UIState<T>()
    data class Fail(val throwable: Throwable) : UIState<Nothing>()
    data object Loading : UIState<Nothing>()
}