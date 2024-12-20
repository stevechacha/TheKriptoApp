package com.chachadev.appthe.core.domain.model

data class ExchangeDetails(
    val id: String,
    val name: String,
    val description: String,
    val active: Boolean,
    val websiteStatus: Boolean,
    val apiStatus: Boolean,
    val message: String?,
    val links: ExchangeLinks?,
    val marketsDataFetched: Boolean,
    val adjustedRank: Int,
    val reportedRank: Int,
    val currencies: Int,
    val markets: Int,
    val fiats: List<Fiat?>,
    val quotes: Map<String, QuoteDetails>,
    val lastUpdated: String,
)