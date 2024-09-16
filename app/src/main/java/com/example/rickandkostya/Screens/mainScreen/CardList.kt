package com.example.rickandkostya.Screens.mainScreen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import org.koin.androidx.compose.koinViewModel


@Composable
fun CardList(viewModel: MainScreenViewModel = koinViewModel()) {
    val cards by viewModel.cards.collectAsState()
    if (cards.isEmpty()) {
        // Показать, например, индикатор загрузки, если данные еще не пришли
        CircularProgressIndicator()
    } else {
        LazyColumn {
            items(cards) { card ->
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