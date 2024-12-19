package com.chachadev.appthe.presentation.screen.coin

import com.chachadev.appthe.core.domain.model.Coin

data class CoinListUiState(
    val isLoading: Boolean = false,
    val coin: List<Coin> = emptyList(),
    val errorMessage: String = ""
)
