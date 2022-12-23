package com.example.myrickymortyapplication.data.resource.remote.dto

import com.example.myrickymortyapplication.domain.model.Character
import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("created")
    val created: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val location: LocationX,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: OriginX,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)

fun CharacterDto.asCharacterModel() : Character{
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        origin = origin,
        gender = gender,
        location = location,
        image = image
    )
}