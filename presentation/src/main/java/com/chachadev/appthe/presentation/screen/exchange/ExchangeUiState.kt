package com.chachadev.appthe.presentation.screen.exchange

import com.chachadev.appthe.core.domain.model.Exchanges

data class ExchangeUiState(
    val errorMessage: String = "",
    val isLoading: Boolean = false,
    val exchanges: List<Exchanges> = emptyList()
)
