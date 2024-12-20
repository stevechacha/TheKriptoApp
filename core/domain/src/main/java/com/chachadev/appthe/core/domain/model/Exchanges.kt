package com.chachadev.appthe.core.domain.model


data class Exchanges(
    val active: Boolean?,
    val adjustedRank: Int?,
    val apiStatus: Boolean?,
    val currencies: Int?,
    val description: String?,
    val fiats: List<Fiat>?,
    val id: String?,
    val lastUpdated: String?,
    val exchangeLinks: ExchangeLinks?,
    val markets: Int?,
    val marketsDataFetched: Boolean?,
    val message: String?,
    val name: String?,
    val quotes: Map<String, QuoteDetails>,
    val reportedRank: Int?,
    val websiteStatus: Boolean?

)

data class ExchangeLinks(
    val twitter: List<String>?,
    val website: List<String>?
)

data class Fiat(
    val name: String,
    val symbol: String
)

data class QuoteDetails(
    val adjustedVolume24h: Long,
    val adjustedVolume30d: Long,
    val adjustedVolume7d: Long,
    val reportedVolume24h: Long,
    val reportedVolume30d: Long,
    val reportedVolume7d: Long
)
