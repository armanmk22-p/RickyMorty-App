package com.example.myrickymortyapplication.presentation.character

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrickymortyapplication.domain.usecases.GetCharacterUseCase
import com.example.myrickymortyapplication.data.result.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel@Inject constructor(private val useCase: GetCharacterUseCase,
private val savedStateHandle: SavedStateHandle) : ViewModel() {


    var state by mutableStateOf(CharacterUiState())
            private set

    private fun getCharacter() {
        savedStateHandle.get<Int>("id")?.let { characterId ->
            viewModelScope.launch {
                useCase(characterId).also { result ->
                    when (result) {
                        is Result.Success-> {
                            state = state.copy(
                                character = result.data,
                                isLoading = false
                            )
                        }
                        is Result.Error -> {
                            state = state.copy(
                                isLoading = false
                            )
                        }
                        is Result.Loading -> {
                            state = state.copy(
                                isLoading = true
                            )
                        }
                    }
                }
            }
        }
    }

}