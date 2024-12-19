package com.chachadev.appthe.core.data.network.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeDetailsDTO(
    val id: String,
    val name: String,
    val description: String,
    val active: Boolean,
    @SerializedName("website_status")
    val websiteStatus: Boolean,
    @SerializedName("api_status")
    val apiStatus: Boolean,
    val message: Any?,
    @SerializedName("links")
    val exchangeDTOLinks: ExchangeDTOLinks?,
    @SerializedName("markets_data_fetched")
    val marketsDataFetched: Boolean,
    @SerializedName("adjusted_rank")
    val adjustedRank: Int,
    @SerializedName("reported_rank")
    val reportedRank: Int,
    val currencies: Int,
    val markets: Int,
    val fiats: List<Any?>,
    val quotesKeyDTO: QuotesKeyDTO,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("img_rev")
    val imgRev: Int,
    @SerializedName("confidence_score")
    val confidenceScore: Int
)