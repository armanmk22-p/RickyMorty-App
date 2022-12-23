package com.example.myrickymortyapplication

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myrickymortyapplication.presentation.character.CharacterScreen
import com.example.myrickymortyapplication.presentation.characters.CharactersScreen


@Composable
fun RickAndMortyNavGraph(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToDetail: (Int) -> Unit,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.CharactersScreen.route
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Screen.CharactersScreen.route) {
            CharactersScreen(
                onItemClicked = { navigateToDetail(it) }
            )
        }
        composable(
            route = Screen.CharacterScreen.route,
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) {
            CharacterScreen(
                upPress = navigateToHome
            )
        }
    }
}