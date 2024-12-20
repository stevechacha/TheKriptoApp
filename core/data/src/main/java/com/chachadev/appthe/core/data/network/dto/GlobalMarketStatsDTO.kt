package com.chachadev.appthe.core.data.network.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GlobalMarketStatsDTO(
    @SerialName("market_cap_usd") val marketCapUsd: Long,
    @SerialName("volume_24h_usd") val volume24hUsd: Long,
    @SerialName("bitcoin_dominance_percentage") val bitcoinDominancePercentage: Double,
    @SerialName("cryptocurrencies_number") val cryptocurrenciesNumber: Int,
    @SerialName("market_cap_ath_value") val marketCapAthValue: Long,
    @SerialName("market_cap_ath_date") val marketCapAthDate: String,
    @SerialName("volume_24h_ath_value") val volume24hAthValue: Long,
    @SerialName("volume_24h_ath_date") val volume24hAthDate: String,
    @SerialName("market_cap_change_24h") val marketCapChange24h: Double,
    @SerialName("volume_24h_change_24h") val volume24hChange24h: Double,
    @SerialName("last_updated") val lastUpdated: Long
)
