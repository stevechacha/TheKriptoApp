package com.chachadev.appthe.presentation.screen.exchange

sealed class ExchangeUiEvent {
    data object GetExchange: ExchangeUiEvent()
}