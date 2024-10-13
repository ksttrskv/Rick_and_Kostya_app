package com.example.rickandkostya.features.mainList.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.rickandkostya.core.network.ApiResult
import com.example.rickandkostya.features.mainList.presentation.MainScreenViewModel
import com.example.rickandkostya.features.mainList.presentation.ui.components.Card
import com.example.rickandkostya.ui.theme.RickAndKostyaTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(viewModel: MainScreenViewModel = getViewModel()) {
    val state by viewModel.state.collectAsState()
    Box(
        modifier = Modifier
            .background(Color.Gray)
            .padding(start = 4.dp, end = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        when (val cards = state.cardsState) {
            is ApiResult.Error -> {
                Text(
                    modifier = Modifier.padding(48.dp),
                    text = cards.error ?: " Error"
                )
            }

            ApiResult.Loading -> {
                CircularProgressIndicator()
            }

            is ApiResult.Success -> {
                if (cards.data.isNullOrEmpty()) {
                    Text(
                        modifier = Modifier.padding(48.dp),
                        text = "Empty"
                    )
                } else {
                    val list = cards.data ?: emptyList()
                    LazyColumn {
                        items(list) { card ->
                            Card(
                                painter = rememberImagePainter(card.painterResourceId),
                                title = card.title,
                                status = card.status,
                                lastLocation = card.lastLocation,
                                firstSee = card.firstSee
                            )
                            Spacer(modifier = Modifier.height(16.dp))

                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    RickAndKostyaTheme {
        MainScreen()
    }
}