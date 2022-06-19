package com.kmm.myapplication.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

open class BaseViewModel {
    protected val viewModelScope = CoroutineScope(Dispatchers.Default)

    protected val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: Flow<Boolean> get() = _loading

    protected val _error: MutableStateFlow<String?> = MutableStateFlow(null)
    val error: Flow<String?> get() = _error
}