package com.example.myrickymortyapplication.data.resource.remote.dto



import com.example.myrickymortyapplication.domain.model.Characters
import com.google.gson.annotations.SerializedName

data class CharactersDto(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)

fun CharactersDto.asCharactersModel() : List<Characters> {

    val finalResult = results.mapIndexed { _, entries ->
        Characters(
            id = entries.id,
            name = entries.name,
            species = entries.species,
            image = entries.image
        )
    }
    return finalResult
}