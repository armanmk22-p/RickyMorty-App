package com.example.myrickymortyapplication.data.resource.remote

import com.example.myrickymortyapplication.data.resource.remote.dto.CharacterDto
import com.example.myrickymortyapplication.data.resource.remote.dto.CharactersDto
import com.example.myrickymortyapplication.data.util.Constans
import retrofit2.http.GET
import retrofit2.http.Path

interface RickyMortyApi {

    @GET(Constans.GET_CHARACTERS)
   suspend fun getCharacters() :CharactersDto

    @GET(Constans.GET_CHARACTER)
    suspend fun getCharacter(@Path("id") id :Int) :CharacterDto
}