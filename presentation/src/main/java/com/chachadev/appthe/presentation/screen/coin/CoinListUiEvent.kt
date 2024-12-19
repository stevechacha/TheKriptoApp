package com.chachadev.appthe.presentation.screen.coin

sealed class CoinListUiEvent {
    data object GetCoin: CoinListUiEvent()
}