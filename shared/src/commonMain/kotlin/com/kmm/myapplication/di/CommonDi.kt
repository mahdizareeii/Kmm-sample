package com.kmm.myapplication.di

import com.kmm.myapplication.domain.usecase.GetAnimalsUseCase
import com.kmm.myapplication.repository.AnimalRepository
import com.kmm.myapplication.viewmodel.AnimalListViewModel
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module


val commonDi = module {

    single {
        HttpClient {
            install(HttpTimeout) {
                requestTimeoutMillis = 30000
                socketTimeoutMillis = 30000
                connectTimeoutMillis = 30000
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                    }
                )
            }
        }
    }

    single { AnimalListViewModel(getAnimalsUseCase = get()) }
    single { GetAnimalsUseCase(animalRepository = get()) }
    single { AnimalRepository(httpClient = get()) }

}