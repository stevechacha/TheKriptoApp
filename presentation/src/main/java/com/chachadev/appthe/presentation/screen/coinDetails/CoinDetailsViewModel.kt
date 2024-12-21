package com.chachadev.appthe.presentation.screen.coinDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chachadev.appthe.core.domain.useCase.GetCoinDetailsUseCase
import com.chachadev.appthe.core.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase
): ViewModel() {
    private val _state = MutableStateFlow(CoinDetailsUiState())
    val state: StateFlow<CoinDetailsUiState> = _state.asStateFlow()


    fun getCoinDetails(coinId: String) {
        getCoinDetailsUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {_state.update { it.copy(isLoading = false,coinDetails = result.data) }}
                is Resource.Loading -> { _state.update { it.copy(isLoading = true) } }
                is Resource.Error -> { _state.update { it.copy(isLoading = false, errorMessage = result.message!!) } }
            }
        }.launchIn(viewModelScope)
    }


}