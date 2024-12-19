package com.chachadev.appthe.core.data.network.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class CoinMappingsDTO(
    @SerializedName("coinpaprika") val coinPaprika: String,
    @SerializedName("coinmarketcap") val coinMarketCap: String?,
    @SerializedName("coingecko") val coinGecko: String?,
    @SerializedName("cryptocompare") val cryptoCompare: String?,
    @SerializedName("isin") val isin: String?,
    @SerializedName("dti") val dti: String?,
    @SerializedName("updated_at") val updatedAt: String
)
