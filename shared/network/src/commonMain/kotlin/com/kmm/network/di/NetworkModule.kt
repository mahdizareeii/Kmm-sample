package com.kmm.network.di

import com.kmm.network.model.AnimalRemoteDataSource
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
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
    single { AnimalRemoteDataSource(httpClient = get()) }
}