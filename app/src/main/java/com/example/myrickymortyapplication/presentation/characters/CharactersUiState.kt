package com.example.myrickymortyapplication.presentation.characters

import com.example.myrickymortyapplication.domain.model.Characters

data class CharactersUiState(
    val isLoading: Boolean = false,
    val characters: List<Characters> = emptyList(),
)
