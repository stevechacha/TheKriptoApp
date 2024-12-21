package com.chachadev.appthe.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinTickerDTO(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    @SerialName("circulating_supply") val circulatingSupply: Long,
    @SerialName("total_supply") val totalSupply: Long,
    @SerialName("max_supply") val maxSupply: Long?,
    @SerialName("beta_value") val betaValue: Double,
    @SerialName("first_data_at") val firstDataAt: String,
    @SerialName("last_updated") val lastUpdated: String,
    val quotes:  QuoteDTO
)

@Serializable
data class QuoteDTO(
    val price: Double,
    @SerialName("volume_24h") val volume24h: Double,
    @SerialName("volume_24h_change_24h") val volume24hChange24h: Double,
    @SerialName("market_cap") val marketCap: Long,
    @SerialName("market_cap_change_24h") val marketCapChange24h: Double,
    @SerialName("percent_change_15m") val percentChange15m: Double?,
    @SerialName("percent_change_30m") val percentChange30m: Double?,
    @SerialName("percent_change_1h") val percentChange1h: Double?,
    @SerialName("percent_change_6h") val percentChange6h: Double?,
    @SerialName("percent_change_12h") val percentChange12h: Double?,
    @SerialName("percent_change_24h") val percentChange24h: Double?,
    @SerialName("percent_change_7d") val percentChange7d: Double?,
    @SerialName("percent_change_30d") val percentChange30d: Double?,
    @SerialName("percent_change_1y") val percentChange1y: Double?,
    @SerialName("ath_price") val athPrice: Double?,
    @SerialName("ath_date") val athDate: String?,
    @SerialName("percent_from_price_ath") val percentFromPriceAth: Double?
)
