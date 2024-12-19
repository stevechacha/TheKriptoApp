package com.chachadev.appthe.core.domain.useCase

import com.chachadev.appthe.core.domain.model.Coin
import com.chachadev.appthe.core.domain.repo.CoinRepository
import com.chachadev.appthe.core.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading())

        when(val coins = repository.getCoins()){
            is Resource.Success -> emit(coins)
            else -> Resource.Error<List<Coin>>(message = coins.message!!)
        }
    }

}