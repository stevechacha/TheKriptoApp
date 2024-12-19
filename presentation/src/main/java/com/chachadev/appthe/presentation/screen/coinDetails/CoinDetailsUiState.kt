package com.chachadev.appthe.presentation.screen.coinDetails

import com.chachadev.appthe.core.domain.model.CoinDetails

data class CoinDetailsUiState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetails? = null,
    val errorMessage: String = ""
)
