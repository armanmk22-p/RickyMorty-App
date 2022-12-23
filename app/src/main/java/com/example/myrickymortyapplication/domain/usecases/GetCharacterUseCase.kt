package com.example.myrickymortyapplication.domain.usecases

import com.example.myrickymortyapplication.domain.repository.RickyMorty
import com.example.myrickymortyapplication.domain.model.Character
import com.example.myrickymortyapplication.data.result.Result
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(private val repo : RickyMorty) {

    suspend operator fun invoke (id : Int) :Result<Character> {
        return repo.getCharacter(id)
    }
}