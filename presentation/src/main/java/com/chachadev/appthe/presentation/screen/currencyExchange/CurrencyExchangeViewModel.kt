package com.chachadev.appthe.presentation.screen.currencyExchange

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chachadev.appthe.core.domain.repo.CoinRepository
import com.chachadev.appthe.core.domain.useCase.GetCurrencyExchangeUseCase
import com.chachadev.appthe.core.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CurrencyExchangeViewModel @Inject constructor(private val currencyExchangeUseCase: GetCurrencyExchangeUseCase): ViewModel() {
    private val _uiState = MutableStateFlow(CurrencyExchangeUiState())
    val uiState : StateFlow<CurrencyExchangeUiState> = _uiState.asStateFlow()

     fun getCurrencyExchange(
        baseCurrencyId : String,
        quoteCurrencyId : String,
        amount : Double
    ){
        currencyExchangeUseCase(
            baseCurrencyId =baseCurrencyId,
            quoteCurrencyId= quoteCurrencyId,
            amount =amount
        ).onEach { result ->
            when(result){
                is Resource.Error -> CurrencyExchangeUiState(error = result.message?:"Error", isLoading = false)
                is Resource.Loading -> CurrencyExchangeUiState(isLoading = true)
                is Resource.Success -> CurrencyExchangeUiState(isLoading = false, data = result.data!!)
            }
        }.launchIn(viewModelScope)
    }

    fun setError(s: String) {
        if (s.isEmpty()){
            return
        }
    }
}