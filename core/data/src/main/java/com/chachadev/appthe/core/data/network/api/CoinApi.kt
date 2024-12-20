package com.chachadev.appthe.core.data.network.api

import com.chachadev.appthe.core.data.network.dto.BlockchainServiceDTO
import com.chachadev.appthe.core.data.network.dto.CoinDTO
import com.chachadev.appthe.core.data.network.dto.CoinDetailsDTO
import com.chachadev.appthe.core.data.network.dto.CoinTickerDTO
import com.chachadev.appthe.core.data.network.dto.CurrencyExchangeDTO
import com.chachadev.appthe.core.data.network.dto.ExchangeCoinDTO
import com.chachadev.appthe.core.data.network.dto.ExchangeMarketDTO
import com.chachadev.appthe.core.data.network.dto.ExchangesDetailsDTO
import com.chachadev.appthe.core.data.network.dto.ExchangesDTO
import com.chachadev.appthe.core.data.network.dto.EventDTO
import com.chachadev.appthe.core.data.network.dto.SocialStatusDTO
import com.chachadev.appthe.core.data.network.dto.GlobalMarketStatsDTO
import com.chachadev.appthe.core.data.network.dto.TickerDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinApi {

    @GET("global")
    suspend fun getGlobalCoin(): GlobalMarketStatsDTO

    @GET("coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("coins/{coin_id}")
    suspend fun getCoinDetails(@Path("coin_id") coinId: String):  CoinDetailsDTO


    @GET("coins/{coin_id}/twitter")
    suspend fun getTwitterTimeline(): SocialStatusDTO

    @GET("coins/{coin_id}/events")
    suspend fun getCoinEventsByCoinId(@Path("") coinId: String): EventDTO

    @GET("coins/{coin_id}/exchanges")
    suspend fun getCoinIdById(@Path("coin_id") coinId: String): ExchangeCoinDTO

    @GET("coins/{coin_id}/markets")
    suspend fun getCoinMarket(@Path("coin_id") coinId: String): ExchangeMarketDTO

    @GET("tags")
    suspend fun getTags():List<BlockchainServiceDTO>

    @GET("tags/{tag_id}")
    suspend fun getTagDetails(@Path("tag_id") tagId: String): BlockchainServiceDTO

    @GET("tickers")
    suspend fun getCoinTickers(): List<CoinTickerDTO>

    @GET("tickers/{coin_id}")
    suspend fun getTickersDetail(@Path("coin_id") coinId: String): TickerDetailsDTO

    @GET("exchanges")
    suspend fun getExchanges(): List<ExchangesDTO>

    @GET("exchanges/{exchange_id}")
    suspend fun getExchangesDetail(@Path("exchange_id") exchangeId: String): ExchangesDetailsDTO

    @GET("exchanges/{exchange_id}/markets")
    suspend fun getExchangeMarkets(@Path("exchange_id") exchangeId : String): ExchangeMarketDTO

    suspend fun getPriceConvert(
        @Query("base_currency_id") baseCurrencyId: String,
        @Query("quote_currency_id") quoteCurrencyId: String,
        @Query("amount") amount: Double
    ): CurrencyExchangeDTO


}