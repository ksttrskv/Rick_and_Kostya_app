package com.example.rickandkostya.Screens.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandkostya.ui.theme.RickAndKostyaTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(viewModel: MainScreenViewModel = koinViewModel()) {
//    val cards by viewModel.cards.collectAsState()
    Box(
        modifier = Modifier
            .background(Color.Gray)
            .padding(start = 4.dp, end = 4.dp)
    ) {
        CardList(viewModel=viewModel)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    RickAndKostyaTheme {
        MainScreen()
    }
}