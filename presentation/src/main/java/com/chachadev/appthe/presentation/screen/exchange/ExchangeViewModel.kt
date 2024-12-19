package com.chachadev.appthe.presentation.screen.exchange

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chachadev.appthe.core.domain.useCase.GetExchangeUseCase
import com.chachadev.appthe.core.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(private val getExchangeUseCase: GetExchangeUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(ExchangeUiState())
    val uiState: StateFlow<ExchangeUiState> = _uiState.asStateFlow()


    init {
        onEvent(ExchangeUiEvent.GetExchange)
    }


    private fun onEvent(event: ExchangeUiEvent){
        when(event){
            ExchangeUiEvent.GetExchange -> {
                getExchangeUseCase().onEach { result ->
                    when(result){
                        is Resource.Success -> {
                            val coins = result.data?: emptyList()
                            _uiState.value = ExchangeUiState(exchanges = coins, isLoading = false)
                        }
                        is Resource.Loading ->  {
                            _uiState.value = ExchangeUiState(isLoading = true)
                        }
                        is Resource.Error -> {
                            _uiState.value = ExchangeUiState(errorMessage = result.message!!, isLoading = false)
                        }
                    }
                }.launchIn(viewModelScope)
            }
        }
    }
}