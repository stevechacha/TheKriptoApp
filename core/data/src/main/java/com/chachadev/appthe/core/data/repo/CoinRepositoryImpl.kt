package com.chachadev.appthe.core.data.repo

import coil.network.HttpException
import com.chachadev.appthe.core.data.mappers.toCoinDetailDomain
import com.chachadev.appthe.core.data.mappers.toCoinDomain
import com.chachadev.appthe.core.data.mappers.toExchange
import com.chachadev.appthe.core.data.mappers.toExchangeDetail
import com.chachadev.appthe.core.data.network.api.CoinApi
import com.chachadev.appthe.core.domain.model.Coin
import com.chachadev.appthe.core.domain.model.CoinDetails
import com.chachadev.appthe.core.domain.model.ExchangeDetails
import com.chachadev.appthe.core.domain.model.Exchanges
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
           Resource.Error<ExchangeDetails>(message = e.localizedMessage?:"")
       } catch (e: HttpException){
           Resource.Error<ExchangeDetails>(message = e.localizedMessage?:"")
       }
    }


}