package com.chachadev.appthe.presentation.screen.exchangeDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chachadev.appthe.core.domain.useCase.GetExchangeDetailsUseCase
import com.chachadev.appthe.core.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ExchangeDetailsViewModel @Inject constructor(private val getExchangeDetailsUseCase: GetExchangeDetailsUseCase): ViewModel() {
    private val _uiState = MutableStateFlow(ExchangeDetailsUiState())
    val exchangeDetailUiState : StateFlow<ExchangeDetailsUiState> = _uiState.asStateFlow()

    fun getExchangeDetails(exchangeId: String){
        getExchangeDetailsUseCase(exchangeId).onEach { results ->
            val exchangeDetails = results.data
            when(results){
                is Resource.Error -> ExchangeDetailsUiState(errorMessage = results.message?:"")
                is Resource.Loading -> ExchangeDetailsUiState(isLoading = true)
                is Resource.Success -> ExchangeDetailsUiState(isLoading = false, data = exchangeDetails)
            }
        }.launchIn(viewModelScope)
    }
}