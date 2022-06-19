package com.kmm.myapplication.network

sealed class NetworkDataState<out T> {
    class Success<T>(val data: T) : NetworkDataState<T>()
    class Error(val message: String) : NetworkDataState<Nothing>()
}