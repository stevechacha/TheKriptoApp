package com.chachadev.appthe.core.domain.model

data class ExchangeDetails(
    val id: String,
    val name: String,
    val description: String,
    val active: Boolean,
    val websiteStatus: Boolean,
    val apiStatus: Boolean,
    val message: Any?,
    val links: ExchangeLinks?,
    val marketsDataFetched: Boolean,
    val adjustedRank: Int,
    val reportedRank: Int,
    val currencies: Int,
    val markets: Int,
    val fiats: List<Any?>,
    val quotes: QuotesKey,
    val lastUpdated: String,
    val imgRev: Int,
    val confidenceScore: Int
)