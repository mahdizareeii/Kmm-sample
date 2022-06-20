package com.kmm.network.model

import com.kmm.network.ktor.safeRequest
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class AnimalRemoteDataSource(
    private val httpClient: HttpClient
) {
    private val baseUrl = "https://zoo-animal-api.herokuapp.com/"
    suspend fun getAnimals() = httpClient.safeRequest<List<AnimalDto>> {
        url(baseUrl + "animals/rand/10")
        method = HttpMethod.Get
    }

}