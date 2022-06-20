package com.kmm.domain.usecase

import com.kmm.domain.UiDataState
import com.kmm.domain.model.Animal
import com.kmm.network.NetworkDataState
import com.kmm.network.model.AnimalDto
import com.kmm.repository.AnimalRepository
import kotlinx.coroutines.flow.flow

class GetAnimalsUseCase(
    private val animalRepository: AnimalRepository
) {
    suspend operator fun invoke() = flow<UiDataState<List<Animal>>> {
        emit(UiDataState.Loading(true))
        emit(
            when (val result = animalRepository.getAnimals()) {
                is NetworkDataState.Success -> UiDataState.Success(
                    result.data.map { mapToAnimal(it) }
                )
                is NetworkDataState.Error -> UiDataState.Error(result.message)
            }
        )
        emit(UiDataState.Loading(false))
    }

    private fun mapToAnimal(dto: AnimalDto): Animal = Animal(
        activeTime = dto.activeTime,
        animalType = dto.animalType,
        diet = dto.diet,
        geoRange = dto.geoRange,
        habitat = dto.habitat,
        id = dto.id,
        imageLink = dto.imageLink,
        latinName = dto.latinName,
        lengthMax = dto.lengthMax,
        lengthMin = dto.lengthMin,
        lifespan = dto.lifespan,
        name = dto.name,
        weightMax = dto.weightMax,
        weightMin = dto.weightMin
    )
}