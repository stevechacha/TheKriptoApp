package com.chachadev.appthe.core.data.repo

import coil.network.HttpException
import com.chachadev.appthe.core.data.mappers.toBlockChainService
import com.chachadev.appthe.core.data.mappers.toCoinDetailDomain
import com.chachadev.appthe.core.data.mappers.toCoinDomain
import com.chachadev.appthe.core.data.mappers.toCoinTicker
import com.chachadev.appthe.core.data.mappers.toCurrencyExchange
import com.chachadev.appthe.core.data.mappers.toEvent
import com.chachadev.appthe.core.data.mappers.toExchange
import com.chachadev.appthe.core.data.mappers.toExchangeCoin
import com.chachadev.appthe.core.data.mappers.toExchangeDetail
import com.chachadev.appthe.core.data.mappers.toExchangeMarket
import com.chachadev.appthe.core.data.mappers.toSocialStatus
import com.chachadev.appthe.core.data.network.api.CoinApi
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
import com.chachadev.appthe.core.domain.repo.CoinRepository
import com.chachadev.appthe.core.domain.util.Resource
import okio.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinApi
) : CoinRepository{
    override suspend fun getCoins(): Resource<List<Coin>> {
        return try {
            val result = coinApi.getCoins().map { it.toCoinDomain() }
            Resource.Success(data = result)
        } catch (e: IOException){
            Resource.Error(message = e.localizedMessage?: "Couldn't reach the server")
        } catch (e: HttpException){
            Resource.Error(message = e.localizedMessage?: "An unexpected error occurred")
        }
    }

    override suspend fun getCoinDetails(coinId: String): Resource<CoinDetails> {
        return try {
            val results = coinApi.getCoinDetails(coinId).toCoinDetailDomain()
            Resource.Success(data = results)
        } catch (e: IOException){
            Resource.Error(message = e.localizedMessage?: "Couldn't reach the server")
        } catch (e: HttpException){
            Resource.Error(message = e.localizedMessage?: "An unexpected error occurred")
        }
    }

    override suspend fun getExchanges(): Resource<List<Exchanges>> {
        return try {
             val response = coinApi.getExchanges().map { it.toExchange() }
            Resource.Success<List<Exchanges>>(data = response)
        } catch (e: IOException){
            Resource.Error<List<Exchanges>>(message = e.localizedMessage?: "")
        } catch (e: HttpException){
            Resource.Error<List<Exchanges>>(message = e.localizedMessage?: "")
        }
    }

    override suspend fun getExchangeDetails(exchangeId: String): Resource<ExchangeDetails> {
       return try {
           val data = coinApi.getExchangesDetail(exchangeId).toExchangeDetail()
           Resource.Success<ExchangeDetails>(data = data)

       } catch (e: IOException){
           Resource.Error<ExchangeDetails>(message = e.localizedMessage?: "Couldn't reach the server")
       } catch (e: HttpException){
           Resource.Error<ExchangeDetails>(message = e.localizedMessage?: "An unexpected error occurred")
       }
    }

    override suspend fun getSocialStatus(coinId: String): Resource<SocialStatus> {
        return try {
            val data = coinApi.getSocialStatus(coinId).toSocialStatus()
            Resource.Success<SocialStatus>(data = data)

        } catch (e: IOException){
            Resource.Error<SocialStatus>(message = e.localizedMessage?: "Couldn't reach the server")
        } catch (e: HttpException){
            Resource.Error<SocialStatus>(message = e.localizedMessage?: "An unexpected error occurred")
        }
    }

    override suspend fun getCoinEventsByCoinId(coinId: String): Resource<Event> {
        return try {
            val results = coinApi.getCoinEventsByCoinId(coinId).toEvent()
            Resource.Success(data = results)
        } catch (e: IOException){
            Resource.Error(message = e.localizedMessage?: "Couldn't reach the server")
        } catch (e: HttpException){
            Resource.Error(message = e.localizedMessage?: "An unexpected error occurred")
        }
    }

    override suspend fun getCoinIdExchanged(coinId: String): Resource<ExchangeCoin> {
        return try {
            val results = coinApi.getCoinIdExchanged(coinId).toExchangeCoin()
            Resource.Success(data = results)
        } catch (e: IOException){
            Resource.Error(message = e.localizedMessage?: "Couldn't reach the server")
        } catch (e: HttpException){
            Resource.Error(message = e.localizedMessage?: "An unexpected error occurred")
        }
    }

    override suspend fun getCoinMarketExchange(coinId: String): Resource<ExchangeMarket> {
        return try {
            val results = coinApi.getCoinMarketExchange(coinId).toExchangeMarket()
            Resource.Success(data = results)
        } catch (e: IOException){
            Resource.Error(message = e.localizedMessage?: "Couldn't reach the server")
        } catch (e: HttpException){
            Resource.Error(message = e.localizedMessage?: "An unexpected error occurred")
        }
    }

    override suspend fun getTags(): Resource<List<BlockchainService>> {
        return try {
            val results = coinApi.getTags().map { it.toBlockChainService() }
            Resource.Success(data = results)
        } catch (e: IOException){
            Resource.Error(message = e.localizedMessage?: "Couldn't reach the server")
        } catch (e: HttpException){
            Resource.Error(message = e.localizedMessage?: "An unexpected error occurred")
        }
    }

    override suspend fun getTagDetails(tagId: String): Resource<BlockchainService> {
        return try {
            val results = coinApi.getTagDetails(tagId).toBlockChainService()
            Resource.Success(data = results)
        } catch (e: IOException){
            Resource.Error(message = e.localizedMessage?: "Couldn't reach the server")
        } catch (e: HttpException){
            Resource.Error(message = e.localizedMessage?: "An unexpected error occurred")
        }
    }

    override suspend fun getCoinTickers(): Resource<List<CoinTicker>> {
        return try {
            val results = coinApi.getCoinTickers().map { it.toCoinTicker() }
            Resource.Success(data = results)
        } catch (e: IOException){
            Resource.Error(message = e.localizedMessage?: "Couldn't reach the server")
        } catch (e: HttpException){
            Resource.Error(message = e.localizedMessage?: "An unexpected error occurred")
        }
    }

    override suspend fun getExchangeMarkets(exchangeId: String): Resource<ExchangeMarket> {
        return try {
            val results = coinApi.getExchangeMarkets(exchangeId).toExchangeMarket()
            Resource.Success(data = results)
        } catch (e: IOException){
            Resource.Error(message = e.localizedMessage?: "Couldn't reach the server")
        } catch (e: HttpException){
            Resource.Error(message = e.localizedMessage?: "An unexpected error occurred")
        }
    }

    override suspend fun getPriceCurrencyConvert(
        baseCurrencyId: String,
        quoteCurrencyId: String,
        amount: Double
    ): Resource<CurrencyExchange> {
        return try {
            val results = coinApi.getPriceConvert(
                baseCurrencyId = baseCurrencyId,
                quoteCurrencyId = quoteCurrencyId,
                amount = amount
            ).toCurrencyExchange()
            Resource.Success(data = results)
        } catch (e: IOException){
            Resource.Error(message = e.localizedMessage?: "Couldn't reach the server")
        } catch (e: HttpException){
            Resource.Error(message = e.localizedMessage?: "An unexpected error occurred")
        }
    }


}