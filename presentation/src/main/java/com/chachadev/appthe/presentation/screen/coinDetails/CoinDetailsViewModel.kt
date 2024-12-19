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
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(private val getCoinDetailsUseCase: GetCoinDetailsUseCase): ViewModel() {
    private val _state = MutableStateFlow(CoinDetailsUiState())
    val state: StateFlow<CoinDetailsUiState> = _state.asStateFlow()


    fun getCoinDetails(coinId: String) {
        getCoinDetailsUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    val coinDetails = result.data
                    _state.value =
                        CoinDetailsUiState(coinDetails = coinDetails, isLoading = false)
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailsUiState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value =
                        CoinDetailsUiState(errorMessage = result.message!!, isLoading = false)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onGetCoinDetailsEvent(coinId: String) {
        getCoinDetailsUseCase(coinId).onEach { result ->
            _state.value = when (result) {
                is Resource.Loading -> CoinDetailsUiState(isLoading = true)
                is Resource.Success -> CoinDetailsUiState(coinDetails = result.data)
                is Resource.Error -> CoinDetailsUiState(errorMessage = result.message!!)
            }
        }.launchIn(viewModelScope)
    }

}