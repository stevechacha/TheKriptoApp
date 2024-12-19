package com.chachadev.appthe.presentation.screen.exchangeDetails

import com.chachadev.appthe.core.domain.model.ExchangeDetails

data class ExchangeDetailsUiState(
    val errorMessage: String = "",
    val isLoading: Boolean = false,
    val data: ExchangeDetails? = null
)
