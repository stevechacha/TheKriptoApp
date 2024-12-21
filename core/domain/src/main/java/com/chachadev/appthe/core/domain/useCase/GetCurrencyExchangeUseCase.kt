package com.chachadev.appthe.core.domain.useCase

import com.chachadev.appthe.core.domain.model.CoinDetails
import com.chachadev.appthe.core.domain.model.CurrencyExchange
import com.chachadev.appthe.core.domain.repo.CoinRepository
import com.chachadev.appthe.core.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCurrencyExchangeUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(
        baseCurrencyId : String,
        quoteCurrencyId : String,
        amount : Double
    ): Flow<Resource<CurrencyExchange>> = flow {
        try {
            emit(Resource.Loading())
            val currencyExchange = repository.getPriceCurrencyConvert(
                baseCurrencyId = baseCurrencyId,
                quoteCurrencyId = quoteCurrencyId,
                amount = amount
            )
            emit(currencyExchange)

        } catch (e: IOException){
            emit(Resource.Error<CurrencyExchange>(message = e.localizedMessage ?: "Unknown error"))
        }
    }
}