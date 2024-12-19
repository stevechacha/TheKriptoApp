package com.chachadev.appthe.core.domain.useCase

import com.chachadev.appthe.core.domain.model.ExchangeDetails
import com.chachadev.appthe.core.domain.repo.CoinRepository
import com.chachadev.appthe.core.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetExchangeDetailsUseCase @Inject constructor (private val coinRepository: CoinRepository) {
    operator fun invoke(exchangeId: String): Flow<Resource<ExchangeDetails>> = flow {
        try {
            emit(Resource.Loading()) // Emit a loading state
            val exchangeDetailsResource = coinRepository.getExchangeDetails(exchangeId)
            emit(exchangeDetailsResource) // Emit the result from the repository
        } catch (e: Exception) {
            emit(Resource.Error<ExchangeDetails>(message = e.localizedMessage ?: "Unknown error"))
        }
    }

}