package com.kmm.myapplication.viewmodel

import com.kmm.myapplication.domain.model.Animal
import com.kmm.myapplication.domain.usecase.GetAnimalsUseCase
import com.kmm.myapplication.domain.UiDataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class AnimalListViewModel(
    private val getAnimalsUseCase: GetAnimalsUseCase
) : BaseViewModel() {
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