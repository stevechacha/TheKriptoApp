package com.chachadev.appthe.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



@Serializable
data class CurrencyExchangeDTO(
    @SerialName("base_currency_id") val baseCurrencyId: String,
    @SerialName("base_currency_name") val baseCurrencyName: String,
    @SerialName("base_price_last_updated") val basePriceLastUpdated: String,
    @SerialName("quote_currency_id") val quoteCurrencyId: String,
    @SerialName("quote_currency_name") val quoteCurrencyName: String,
    @SerialName("quote_price_last_updated") val quotePriceLastUpdated: String,
    @SerialName("amount") val amount: Double,
    @SerialName("price") val price: Double
)
