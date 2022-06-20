package com.kmm.domain.di

import com.kmm.domain.usecase.GetAnimalsUseCase
import org.koin.dsl.module

val domainCommonModule = module {
    single { GetAnimalsUseCase(animalRepository = get()) }
}