package com.example.myrickymortyapplication.presentation.character
import com.example.myrickymortyapplication.domain.model.Character
data class CharacterUiState(
    val character :Character? = null,
    val isLoading :Boolean =false
)