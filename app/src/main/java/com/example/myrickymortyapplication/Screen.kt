package com.example.myrickymortyapplication

sealed class Screen(val route: String){

    object CharactersScreen: Screen("character_list_screen")
    object CharacterScreen: Screen("character_detail_screen")
}
