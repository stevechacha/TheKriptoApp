package com.chachadev.appthe.core.domain.useCase

import com.chachadev.appthe.core.domain.model.CoinDetails
import com.chachadev.appthe.core.domain.repo.CoinRepository
import com.chachadev.appthe.core.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading()) // Emit a loading state
            val coinDetail = repository.getCoinDetails(coinId)
            emit(coinDetail) // Emit the result from the repository
        } catch (e: Exception) {
            emit(Resource.Error<CoinDetails>(message = e.localizedMessage ?: "Unknown error"))
        }
    }

//    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
//        emit(Resource.Loading())
//        when(val coinDetail = repository.getCoinDetails(coinId)){
//            is Resource.Success -> emit(coinDetail)
//            else -> Resource.Error<CoinDetails>(data = null, message = coinDetail.message!!)
//        }
//    }
}