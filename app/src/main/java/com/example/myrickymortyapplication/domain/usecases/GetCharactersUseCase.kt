package com.example.myrickymortyapplication.domain.usecases

import com.example.myrickymortyapplication.domain.model.Characters
import com.example.myrickymortyapplication.domain.repository.RickyMorty
import com.example.myrickymortyapplication.data.result.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repo: RickyMorty) {

    operator fun invoke(): Flow<Result<List<Characters>>>{
        return repo.getCharacters()
    }

}