package com.example.myrickymortyapplication.presentation.character

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import com.example.myrickymortyapplication.domain.model.Character
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.myrickymortyapplication.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myrickymortyapplication.presentation.characters.CharacterImage
import com.example.myrickymortyapplication.presentation.characters.CharactersItem

@Composable
fun CharacterScreen(
    viewModel:CharacterViewModel = hiltViewModel(),
    upPress: () -> Unit){
        val state = viewModel.state
        DetailContent(
            character = state.character,
            upPress = upPress
        )

}


@Composable
private fun DetailContent(
    modifier: Modifier = Modifier,
   character: Character?,
    upPress: () -> Unit
) {
    Box(modifier.fillMaxSize()) {
        Column {
            Header(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                character = character
            )
            Body(character = character)
        }
        Up(upPress)
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier,
    character: Character?
) {
    Column(
        modifier = modifier.background(Color(0xffffe0b2)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CharacterImage(image = character?.image)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = character?.name ?: "",
            style = MaterialTheme.typography.h5,
            color = Color.White
        )
    }
}


@Composable
private fun Body(character: Character?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        DetailProperty(label = stringResource(R.string.specie), value = character?.species, imageVector = Icons.Filled.Favorite)
        DetailProperty(label = stringResource(R.string.status), value = character?.status, imageVector = Icons.Outlined.Star)
        DetailProperty(label = stringResource(R.string.gender), value = character?.gender, imageVector = Icons.Outlined.Add)
        DetailProperty(label = stringResource(R.string.first_location), value = character?.origin?.name, imageVector = Icons.Outlined.Favorite)
        DetailProperty(label = stringResource(R.string.last_location), value = character?.location?.name, imageVector = Icons.Outlined.LocationOn)
    }
}

@Composable
private fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 10.dp)
            .size(36.dp)
    ) {

    }
}

