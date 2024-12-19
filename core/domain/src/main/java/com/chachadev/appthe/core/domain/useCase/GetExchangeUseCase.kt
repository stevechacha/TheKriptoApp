package com.chachadev.appthe.core.domain.useCase

import com.chachadev.appthe.core.domain.model.Coin
import com.chachadev.appthe.core.domain.model.Exchanges
import com.chachadev.appthe.core.domain.repo.CoinRepository
import com.chachadev.appthe.core.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetExchangeUseCase @Inject constructor (private val coinRepository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Exchanges>>> = flow {
        emit(Resource.Loading())

        when(val exchanges = coinRepository.getExchanges()){
            is Resource.Success -> emit(exchanges)
            else -> Resource.Error<List<Exchanges>>(message = exchanges.message!!)
        }
    }
}