package com.example.myrickymortyapplication.presentation.characters

sealed class CharactersUiEvent {

    data class ShowSnackBar(val message: String): CharactersUiEvent()

}


