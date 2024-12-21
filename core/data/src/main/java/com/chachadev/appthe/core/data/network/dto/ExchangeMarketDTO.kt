package com.chachadev.appthe.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeMarketDTO(
    @SerialName("exchange_id") val exchangeId: String,
    @SerialName("exchange_name") val exchangeName: String,
    @SerialName("pair") val pair: String,
    @SerialName("base_currency_id") val baseCurrencyId: String,
    @SerialName("base_currency_name") val baseCurrencyName: String,
    @SerialName("quote_currency_id") val quoteCurrencyId: String,
    @SerialName("quote_currency_name") val quoteCurrencyName: String,
    @SerialName("market_url") val marketUrl: String,
    @SerialName("category") val category: String,
    @SerialName("fee_type") val feeType: String,
    @SerialName("outlier") val outlier: Boolean,
    @SerialName("adjusted_volume_24h_share") val adjustedVolume24hShare: Double,
    val quotes: ExchangeMarketQuoteDTO,
    @SerialName("last_updated") val lastUpdated: String
)

@Serializable
data class ExchangeMarketQuoteDTO(
    val price: Double,
    @SerialName("volume_24h") val volume24h: Double
)


