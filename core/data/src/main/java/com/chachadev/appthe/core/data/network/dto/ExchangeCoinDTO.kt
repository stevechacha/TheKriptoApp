package com.chachadev.appthe.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



@Serializable
data class ExchangeCoinDTO(
    val id: String,
    val name: String,
    val fiats: List<FiatDTO>,
    @SerialName("adjusted_volume_24h_share") val adjustedVolume24hShare: Double
)

@Serializable
data class ExchangeCoinDTOFiatDTO(
    val name: String,
    val symbol: String
)