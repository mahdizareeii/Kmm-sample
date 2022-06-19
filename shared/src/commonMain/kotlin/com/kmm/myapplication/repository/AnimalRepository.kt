package com.kmm.myapplication.repository

import com.kmm.myapplication.ktor.safeRequest
import com.kmm.myapplication.network.model.AnimalDto
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.withContext

class AnimalRepository(
    private val httpClient: HttpClient
) : BaseRepository() {

    suspend fun getAnimals() = withContext(dispatcher) {
        httpClient.safeRequest<List<AnimalDto>> {
            url(baseUrl + "animals/rand/10")
            method = HttpMethod.Get
        }
    }

}