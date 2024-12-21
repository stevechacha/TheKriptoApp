package com.chachadev.appthe.core.data.network.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangesDTO(
    val id: String?,
    val name: String,
    val active: Boolean?,
    @SerializedName("website_status") val websiteStatus: Boolean?,
    @SerializedName("api_status") val apiStatus: Boolean?,
    val description: String?,
    val message: String?,
    @SerializedName("links") val exchangeDTOLinks: ExchangeDTOLinks?,
    @SerializedName("markets_data_fetched") val marketsDataFetched: Boolean?,
    @SerializedName("adjusted_rank") val adjustedRank: Int?,
    @SerializedName("reported_rank") val reportedRank: Int?,
    val currencies: Int?,
    val markets: Int?,
    val fiats: List<FiatDTO>?,
    val quotes: QuoteDetailsDTO?,
    @SerializedName("last_updated") val lastUpdated: String?,
    @SerializedName("confidence_score") val confidenceScore: Double?,
    @SerializedName("sessions_per_month")
    val sessionsPerMonth: Long?
)

@Serializable
data class ExchangeDTOLinks(
    val website: List<String>?,
    val twitter: List<String>?
)




