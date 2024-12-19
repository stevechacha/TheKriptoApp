package com.chachadev.appthe.core.data.network.api

import com.chachadev.appthe.core.data.network.dto.CoinDTO
import com.chachadev.appthe.core.data.network.dto.CoinDetailsDTO
import com.chachadev.appthe.core.data.network.dto.CoinMappingsDTO
import com.chachadev.appthe.core.data.network.dto.ExchangeDetailsDTO
import com.chachadev.appthe.core.data.network.dto.ExchangesDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinApi {
    @GET("coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("coins/{coin_id}")
    suspend fun getCoinDetails(
        @Path("coin_id") coinId: String
    ):  CoinDetailsDTO

    @GET("coins/mappings")
    suspend fun getCoinMappings(
        @Query("coinpaprika") coinPaprikaId: String? = null,
        @Query("coinmarketcap") coinMarketCapId: String? = null,
        @Query("coingecko") coinGeckoId: String? = null,
        @Query("cryptocompare") cryptoCompareId: String? = null,
        @Query("isin") isinId: String? = null,
        @Query("dti") dtiId: String? = null
    ): CoinMappingsDTO

    @GET("exchanges")
    suspend fun getExchanges(): List<ExchangesDTO>

    @GET("exchanges/{exchange_id}")
    suspend fun getExchangesDetail(
        @Path("exchange_id") exchangeId: String
    ): ExchangeDetailsDTO



}