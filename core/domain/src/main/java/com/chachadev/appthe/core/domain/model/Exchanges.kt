package com.chachadev.appthe.core.domain.model


data class Exchanges(
    val active: Boolean?,
    val adjustedRank: Int?,
    val apiStatus: Boolean?,
    val confidenceScore: Double?,
    val currencies: Int?,
    val description: String?,
    val fiats: List<Fiat>?,
    val id: String?,
    val lastUpdated: String?,
    val exchangeLinks: ExchangeLinks?,
    val markets: Int?,
    val marketsDataFetched: Boolean?,
    val message: Any?,
    val name: String?,
    val quotesKey: QuotesKey?,
    val reportedRank: Int?,
    val sessionsPerMonth: Int?,
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

data class QuotesKey(
    val adjustedVolume24h: Int,
    val adjustedVolume30d: Int,
    val adjustedVolume7d: Int,
    val reportedVolume24h: Int,
    val reportedVolume30d: Int,
    val reportedVolume7d: Int
)
