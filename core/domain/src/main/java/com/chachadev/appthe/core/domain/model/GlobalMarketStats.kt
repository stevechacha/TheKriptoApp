package com.chachadev.appthe.core.domain.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

data class GlobalMarketStats(
    val marketCapUsd: Long,
    val volume24hUsd: Long,
    val bitcoinDominancePercentage: Double,
    val cryptocurrenciesNumber: Int,
    val marketCapAthValue: Long,
    val marketCapAthDate: String,
    val volume24hAthValue: Long,
    val volume24hAthDate: String,
    val marketCapChange24h: Double,
    val volume24hChange24h: Double,
    val lastUpdated: Long
)
