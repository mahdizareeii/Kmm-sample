package com.kmm.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmm.domain.UiDataState
import com.kmm.domain.model.Animal
import com.kmm.domain.usecase.GetAnimalsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

actual class AnimalListViewModel actual constructor() : ViewModel() {

    private val getAnimalsUseCase by inject<GetAnimalsUseCase>()

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: Flow<Boolean> get() = _loading

    private val _error: MutableStateFlow<String?> = MutableStateFlow(null)
    val error: Flow<String?> get() = _error

    private val _animals: MutableStateFlow<List<Animal>> = MutableStateFlow(listOf())
    val animals: Flow<List<Animal>> get() = _animals

    init {
        request()
    }

    private fun request() {
        viewModelScope.launch {
            getAnimalsUseCase.invoke()
                .onEach {
                    when (it) {
                        is UiDataState.Loading -> _loading.emit(it.isLoading)
                        is UiDataState.Success -> _animals.emit(it.data)
                        is UiDataState.Error -> _error.emit(it.message)
                    }
                }.launchIn(viewModelScope)
        }
    }
}