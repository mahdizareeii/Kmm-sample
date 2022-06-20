package com.kmm.domain.viewmodel

import com.kmm.domain.usecase.GetAnimalsUseCase

expect class AnimalListViewModel(){
    val getAnimalsUseCase: GetAnimalsUseCase
}