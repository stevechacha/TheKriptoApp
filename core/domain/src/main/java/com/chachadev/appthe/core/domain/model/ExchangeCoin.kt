package com.chachadev.appthe.core.domain.model


data class ExchangeCoin(
    val id: String,
    val name: String,
    val fiats: List<Fiat>,
   val adjustedVolume24hShare: Double
)

data class ExchangeCoinDTOFiat(
    val name: String,
    val symbol: String
)