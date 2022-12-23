package com.example.myrickymortyapplication.data.repository


import android.util.Log
import com.example.myrickymortyapplication.data.resource.remote.RickyMortyApi
import com.example.myrickymortyapplication.data.resource.remote.dto.asCharacterModel
import com.example.myrickymortyapplication.data.resource.remote.dto.asCharactersModel
import com.example.myrickymortyapplication.data.result.Result
import com.example.myrickymortyapplication.domain.model.Characters
import com.example.myrickymortyapplication.domain.model.Character
import com.example.myrickymortyapplication.domain.repository.RickyMorty
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RickyMortyImpl @Inject constructor(private val api: RickyMortyApi) : RickyMorty {
    override fun getCharacters(): Flow<Result<List<Characters>>> = flow {
        emit(Result.Loading())

        try {
            val response = api.getCharacters().asCharactersModel()
            emit(Result.Success(response))
        } catch (e: HttpException) {
            emit(
                Result.Error(
                    message = "Unknown Result",
                    data = null
                )
            )
        } catch (e: IOException) {
            emit(
                Result.Error(
                    message = "check your internet",
                    data = null
                )
            )
        }
    }

    override suspend fun getCharacter(id: Int): Result<Character> {
        return try {
            val response = api.getCharacter(id).asCharacterModel()
            Result.Success(response)
        }catch (e :Exception){
            Result.Error(
                message = "Unknown error",
                data = null
            )
        }
    }

}