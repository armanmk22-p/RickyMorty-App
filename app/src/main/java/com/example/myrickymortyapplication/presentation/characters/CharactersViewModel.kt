package com.example.myrickymortyapplication.presentation.characters

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrickymortyapplication.domain.usecases.GetCharactersUseCase
import com.example.myrickymortyapplication.data.result.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val useCase: GetCharactersUseCase) : ViewModel() {

    var state by mutableStateOf(CharactersUiState())
        private set

    private val _eventFlow = MutableSharedFlow<CharactersUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {

        getCharacters()
    }
    fun getCharacters() {
        viewModelScope.launch {
            useCase().onEach {
                when (it) {

                    is Result.Success -> {
                       state= state.copy(
                                characters = it.data ?: emptyList()
                        )

                    }

                    is Result.Error -> {
                        state= state.copy(
                            isLoading = false
                        )
                        _eventFlow.emit(
                            CharactersUiEvent.ShowSnackBar(
                                it.message ?: "Unknown error"
                            )
                        )

                    }

                    is Result.Loading -> {
                        state = state.copy(
                            isLoading = true
                        )

                    }
                }
            }.launchIn(this)
        }
    }
}