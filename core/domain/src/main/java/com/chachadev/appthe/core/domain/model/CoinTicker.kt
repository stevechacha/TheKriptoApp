package com.chachadev.appthe.core.domain.model

data class CoinTicker(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val circulatingSupply: Long,
    val totalSupply: Long,
    val maxSupply: Long?,
    val betaValue: Double,
    val firstDataAt: String,
    val lastUpdated: String,
    val quotes: Quote
)

data class Quote(
    val price: Double,
    val volume24h: Double,
    val volume24hChange24h: Double,
    val marketCap: Long,
    val marketCapChange24h: Double,
    val percentChange15m: Double?,
    val percentChange30m: Double?,
    val percentChange1h: Double?,
    val percentChange6h: Double?,
    val percentChange12h: Double?,
    val percentChange24h: Double?,
    val percentChange7d: Double?,
    val percentChange30d: Double?,
    val percentChange1y: Double?,
    val athPrice: Double?,
    val athDate: String?,
    val percentFromPriceAth: Double?
)