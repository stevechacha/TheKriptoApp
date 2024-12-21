package com.chachadev.appthe.core.data.network.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class ExchangesDetailsDTO(
    val id: String,
    val name: String,
    val description: String,
    val active: Boolean,
    @SerializedName("website_status") val websiteStatus: Boolean,
    @SerializedName("api_status") val apiStatus: Boolean,
    val message: String?,
    @SerializedName("links") val exchangeDTOLinks: ExchangeDTOLinks?,
    @SerializedName("markets_data_fetched") val marketsDataFetched: Boolean,
    @SerializedName("adjusted_rank") val adjustedRank: Int,
    @SerializedName("reported_rank") val reportedRank: Int,
    val currencies: Int,
    val markets: Int,
    val fiats: List<Any>,
    val quotes: QuoteDetailsDTO?,
    @SerializedName("last_updated") val lastUpdated: String,
    @SerializedName("confidence_score")
    val confidenceScore: Int,
    @SerializedName("img_rev")
    val imgRev: Int,
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

