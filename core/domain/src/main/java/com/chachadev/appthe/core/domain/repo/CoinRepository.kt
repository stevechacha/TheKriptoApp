package com.chachadev.appthe.core.domain.repo

import com.chachadev.appthe.core.domain.model.BlockchainService
import com.chachadev.appthe.core.domain.model.Coin
import com.chachadev.appthe.core.domain.model.CoinDetails
import com.chachadev.appthe.core.domain.model.CoinTicker
import com.chachadev.appthe.core.domain.model.CurrencyExchange
import com.chachadev.appthe.core.domain.model.Event
import com.chachadev.appthe.core.domain.model.ExchangeCoin
import com.chachadev.appthe.core.domain.model.ExchangeDetails
import com.chachadev.appthe.core.domain.model.ExchangeMarket
import com.chachadev.appthe.core.domain.model.Exchanges
import com.chachadev.appthe.core.domain.model.SocialStatus
import com.chachadev.appthe.core.domain.util.Resource

interface CoinRepository {
    suspend fun getCoins(): Resource<List<Coin>>
    suspend fun getCoinDetails(coinId: String) : Resource<CoinDetails>
    suspend fun getExchanges(): Resource<List<Exchanges>>
    suspend fun getExchangeDetails(exchangeId: String): Resource<ExchangeDetails>
    suspend fun getSocialStatus(coinId: String): Resource<SocialStatus>
    suspend fun getCoinEventsByCoinId(coinId: String): Resource<Event>
    suspend fun getCoinIdExchanged(coinId: String): Resource<ExchangeCoin>
    suspend fun getCoinMarketExchange(coinId: String): Resource<ExchangeMarket>
    suspend fun getTags(): Resource<List<BlockchainService>>
    suspend fun getTagDetails(tagId: String): Resource<BlockchainService>
    suspend fun getCoinTickers(): Resource<List<CoinTicker>>
    suspend fun getExchangeMarkets(exchangeId: String): Resource<ExchangeMarket>
    suspend fun getPriceCurrencyConvert(
       baseCurrencyId: String,
       quoteCurrencyId: String,
       amount: Double
    ): Resource<CurrencyExchange>
}