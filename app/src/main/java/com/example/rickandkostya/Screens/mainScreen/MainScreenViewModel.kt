package com.example.rickandkostya.Screens.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.GetCharactersUseCase
import com.example.domain.GetEpisodeDetailsUseCase
import com.example.domain.GetLocationDetailsUseCase
import com.example.domain.Models.CardData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainScreenViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getLocationDetailsUseCase: GetLocationDetailsUseCase,
    private val getEpisodeDetailsUseCase: GetEpisodeDetailsUseCase
) : ViewModel(), KoinComponent {
//    private val getCharactersUseCase: GetCharactersUseCase by inject()
//    private val getLocationDetailsUseCase: GetLocationDetailsUseCase by inject()
//    private val getEpisodeDetailsUseCase: GetEpisodeDetailsUseCase by inject()

    private val _cards: MutableStateFlow<List<CardData>> = MutableStateFlow(emptyList())
    val cards: StateFlow<List<CardData>> = _cards

    init {
        fetchCharactersFromApi()
    }

    private fun fetchCharactersFromApi() {
        viewModelScope.launch {
            val characters = getCharactersUseCase.execute()

            val characterCards = characters.map { character ->
                val location = getLocationDetailsUseCase.execute(character.location.url)
                val firstEpisode =
                    getEpisodeDetailsUseCase.execute(character.episode.firstOrNull().toString())

                CardData(
                    painterResourceId = character.image,
                    title = character.name,
                    status = "${character.status} - ${character.species}",
                    lastLocation = location ?: "Unknown",
                    firstSee = firstEpisode ?: "Unknown"
                )
            }

            _cards.value = characterCards
        }
    }
}


