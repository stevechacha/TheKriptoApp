package com.chachadev.appthe.core.domain.model


data class CurrencyExchange(
    val baseCurrencyId: String,
    val baseCurrencyName: String,
    val basePriceLastUpdated: String,
    val quoteCurrencyId: String,
    val quoteCurrencyName: String,
    val quotePriceLastUpdated: String,
    val amount: Double,
    val price: Double
)