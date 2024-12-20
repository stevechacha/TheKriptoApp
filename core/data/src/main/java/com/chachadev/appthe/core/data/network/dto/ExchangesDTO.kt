package com.chachadev.appthe.core.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangesDTO(
    val id: String,
    val name: String,
    val active: Boolean,
    @SerialName("website_status") val websiteStatus: Boolean,
    @SerialName("api_status") val apiStatus: Boolean,
    val description: String,
    val message: String?,
    @SerialName("links") val exchangeDTOLinks: ExchangeDTOLinks,
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
data class ExchangeDTOLinks(
    val website: List<String>,
    val twitter: List<String>?
)



