package com.chachadev.appthe.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangesDetailsDTO(
    val id: String,
    val name: String,
    val description: String,
    val active: Boolean,
    @SerialName("website_status") val websiteStatus: Boolean,
    @SerialName("api_status") val apiStatus: Boolean,
    val message: String?,
    @SerialName("links") val exchangeDTOLinks: ExchangeDTOLinks?,
    @SerialName("markets_data_fetched") val marketsDataFetched: Boolean,
    @SerialName("adjusted_rank") val adjustedRank: Int,
    @SerialName("reported_rank") val reportedRank: Int,
    val currencies: Int,
    val markets: Int,
    val fiats: List<FiatDTO>,
    val quotes: Map<String, QuoteDetailsDTO>,
    @SerialName("last_updated") val lastUpdated: String
)


@Serializable
data class QuoteDetailsDTO(
    @SerialName("reported_volume_24h") val reportedVolume24h: Long,
    @SerialName("adjusted_volume_24h") val adjustedVolume24h: Long,
    @SerialName("reported_volume_7d") val reportedVolume7d: Long,
    @SerialName("adjusted_volume_7d") val adjustedVolume7d: Long,
    @SerialName("reported_volume_30d") val reportedVolume30d: Long,
    @SerialName("adjusted_volume_30d") val adjustedVolume30d: Long
)

