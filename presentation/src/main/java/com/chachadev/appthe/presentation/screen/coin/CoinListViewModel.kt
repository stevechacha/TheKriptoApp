package com.chachadev.appthe.presentation.screen.coin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chachadev.appthe.core.domain.useCase.GetCoinsUseCase
import com.chachadev.appthe.core.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinsUseCase: GetCoinsUseCase
) : ViewModel(){
    private val _uiState = MutableStateFlow(CoinListUiState())
    val uiState = _uiState.asStateFlow()

    init {
        onCoinEvent(CoinListUiEvent.GetCoin)
    }

    private fun onCoinEvent(event: CoinListUiEvent){
        when(event){
            CoinListUiEvent.GetCoin -> {
                coinsUseCase().onEach { result ->
                    when(result){
                        is Resource.Success -> {
                            val coins = result.data?: emptyList()
                            _uiState.value = CoinListUiState(coin = coins, isLoading = false)
                        }
                        is Resource.Loading ->  {
                            _uiState.value = CoinListUiState(isLoading = true)
                        }
                        is Resource.Error -> {
                            _uiState.value = CoinListUiState(errorMessage = result.message!!, isLoading = false)
                        }
                    }
                }.launchIn(viewModelScope)
            }
        }
    }


}