package com.chachadev.appthe.core.data.network.dto

import com.google.gson.annotations.SerializedName

data class ExchangesDTO(
    val active: Boolean?,
    @SerializedName("adjusted_rank")
    val adjustedRank: Int?,
    @SerializedName("api_status")
    val apiStatus: Boolean?,
    @SerializedName("confidence_score")
    val confidenceScore: Double?,
    val currencies: Int?,
    val description: String?,
    val fiatDTO: List<FiatDTO>?,
    val id: String?,
    @SerializedName("last_updated")
    val lastUpdated: String?,
    @SerializedName("links")
    val exchangeDTOLinks: ExchangeDTOLinks?,
    val markets: Int?,
    @SerializedName("markets_data_fetched")
    val marketsDataFetched: Boolean?,
    val message: Any?,
    val name: String?,
    val quotesKeyDTO: QuotesKeyDTO?,
    @SerializedName("reported_rank")
    val reportedRank: Int?,
    @SerializedName("sessions_per_month")
    val sessionsPerMonth: Long?,
    @SerializedName("website_status")
    val websiteStatus: Boolean?
)

data class ExchangeDTOLinks(
    val twitter: List<String>?,
    val website: List<String>?
)

data class FiatDTO(
    val name: String,
    val symbol: String
)

data class QuotesKeyDTO(
    val adjustedVolume24h: Int,
    val adjustedVolume30d: Int,
    val adjustedVolume7d: Int,
    val reportedVolume24h: Int,
    val reportedVolume30d: Int,
    val reportedVolume7d: Int
)
