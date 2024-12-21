package com.chachadev.appthe.presentation.screen.currencyExchange

import com.chachadev.appthe.core.domain.model.CurrencyExchange

data class CurrencyExchangeUiState(
    val data: CurrencyExchange? = null,
    val error: String = "",
    val isLoading: Boolean = false
)

data class Currency(
    val name: String,
    val id: String,
    val symbol: String
)
