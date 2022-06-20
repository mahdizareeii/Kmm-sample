package com.kmm.repository

import com.kmm.network.model.AnimalRemoteDataSource
import kotlinx.coroutines.withContext

class AnimalRepository(
    private val dataSource: AnimalRemoteDataSource
) : BaseRepository() {

    suspend fun getAnimals() = withContext(dispatcher) {
        dataSource.getAnimals()
    }

}