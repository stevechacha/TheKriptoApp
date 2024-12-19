package com.chachadev.appthe.core.domain.repo

import com.chachadev.appthe.core.domain.model.Coin
import com.chachadev.appthe.core.domain.model.CoinDetails
import com.chachadev.appthe.core.domain.model.ExchangeDetails
import com.chachadev.appthe.core.domain.model.Exchanges
import com.chachadev.appthe.core.domain.util.Resource

interface CoinRepository {
    suspend fun getCoins(): Resource<List<Coin>>
    suspend fun getCoinDetails(coinId: String) : Resource<CoinDetails>
    suspend fun getExchanges(): Resource<List<Exchanges>>
    suspend fun getExchangeDetails(exchangeId: String): Resource<ExchangeDetails>
}