package com.kmm.repository.di

import com.kmm.repository.AnimalRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AnimalRepository(dataSource = get()) }
}