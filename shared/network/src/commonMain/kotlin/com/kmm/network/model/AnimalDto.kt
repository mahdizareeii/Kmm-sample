package com.kmm.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimalDto(
    @SerialName("active_time")
    val activeTime: String? = null,
    @SerialName("animal_type")
    val animalType: String? = null,
    @SerialName("diet")
    val diet: String? = null,
    @SerialName("geo_range")
    val geoRange: String? = null,
    @SerialName("habitat")
    val habitat: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image_link")
    val imageLink: String? = null,
    @SerialName("latin_name")
    val latinName: String? = null,
    @SerialName("length_max")
    val lengthMax: String? = null,
    @SerialName("length_min")
    val lengthMin: String? = null,
    @SerialName("lifespan")
    val lifespan: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("weight_max")
    val weightMax: String? = null,
    @SerialName("weight_min")
    val weightMin: String? = null
)