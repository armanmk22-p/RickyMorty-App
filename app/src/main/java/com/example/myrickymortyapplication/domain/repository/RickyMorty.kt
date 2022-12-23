package com.example.myrickymortyapplication.domain.repository


import com.example.myrickymortyapplication.domain.model.Characters
import com.example.myrickymortyapplication.domain.model.Character
import com.example.myrickymortyapplication.data.result.Result
import kotlinx.coroutines.flow.Flow

interface RickyMorty {

    fun getCharacters(): Flow<Result<List<Characters>>>

    suspend fun getCharacter(id: Int): Result<Character>
}