package com.chachadev.appthe.core.domain.model

data class ExchangeMarket(
    val exchangeId: String,
    val exchangeName: String,
    val pair: String,
    val baseCurrencyId: String,
    val baseCurrencyName: String,
    val quoteCurrencyId: String,
    val quoteCurrencyName: String,
    val marketUrl: String,
    val category: String,
    val feeType: String,
    val outlier: Boolean,
    val adjustedVolume24hShare: Double,
    val quotes: ExchangeMarketQuote,
    val lastUpdated: String
)

data class ExchangeMarketQuote(
    val price: Double,
    val volume24h: Double
)