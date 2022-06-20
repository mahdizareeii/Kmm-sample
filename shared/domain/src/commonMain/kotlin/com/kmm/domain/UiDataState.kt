package com.kmm.domain

sealed class UiDataState<out T> {
    class Success<T>(val data: T) : UiDataState<T>()
    class Error(val message: String) : UiDataState<Nothing>()
    class Loading(val isLoading: Boolean) : UiDataState<Nothing>()
}