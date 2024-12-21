package com.chachadev.appthe.theapp.di

import com.chachadev.appthe.core.domain.repo.CoinRepository
import com.chachadev.appthe.core.domain.useCase.GetCoinDetailsUseCase
import com.chachadev.appthe.core.domain.useCase.GetCoinsUseCase
import com.chachadev.appthe.core.domain.useCase.GetCurrencyExchangeUseCase
import com.chachadev.appthe.core.domain.useCase.GetExchangeDetailsUseCase
import com.chachadev.appthe.core.domain.useCase.GetExchangeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {
    @Provides
    @Singleton
    fun providesCoinUse(repository: CoinRepository): GetCoinsUseCase{
        return GetCoinsUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesCoinDetailsUseCase(repository: CoinRepository): GetCoinDetailsUseCase {
        return GetCoinDetailsUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesExchangeUseCase(coinRepository: CoinRepository): GetExchangeUseCase{
        return GetExchangeUseCase(coinRepository)
    }

    @Provides
    @Singleton
    fun getExchangeDetailsUseCase(coinRepository: CoinRepository): GetExchangeDetailsUseCase {
        return GetExchangeDetailsUseCase(coinRepository)
    }

    @Provides
    @Singleton
    fun provideCurrencyExchangeUseCase(coinRepository: CoinRepository): GetCurrencyExchangeUseCase{
        return GetCurrencyExchangeUseCase(coinRepository)
    }
}