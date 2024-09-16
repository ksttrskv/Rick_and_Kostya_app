package com.example.rickandkostya.features.mainList.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandkostya.core.network.ApiResult
import com.example.rickandkostya.features.mainList.domain.GetCharactersUseCase
import com.example.rickandkostya.features.mainList.presentation.models.CharacterCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
) : ViewModel() {

    private val _state: MutableStateFlow<MainScreenUiState> = MutableStateFlow(MainScreenUiState())
    val state: StateFlow<MainScreenUiState> = _state

    init {
        fetchCharactersFromApi()
    }

    private fun fetchCharactersFromApi() {
        viewModelScope.launch {
            getCharactersUseCase.execute().collect { result ->
                val characters = when (result) {
                    is ApiResult.Error -> {
                        ApiResult.Error(result.error)
                    }

                    ApiResult.Loading -> {
                        ApiResult.Loading
                    }

                    is ApiResult.Success -> {
                        ApiResult.Success(
                            result.data?.results?.map {
                                CharacterCard(
                                    painterResourceId = it.image,
                                    title = it.name,
                                    status = "${it.status} - ${it.species}",
                                    lastLocation = it.location.name,
                                    firstSee = it.episode.firstOrNull().toString()
                                )
                            }
                        )
                    }
                }
                _state.value = MainScreenUiState(characters)
            }

        }
    }
}

data class MainScreenUiState(
    val cardsState: ApiResult<List<CharacterCard>?> = ApiResult.Loading
)