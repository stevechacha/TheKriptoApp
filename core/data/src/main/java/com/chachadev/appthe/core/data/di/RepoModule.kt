package com.chachadev.appthe.core.data.di

import com.chachadev.appthe.core.data.repo.CoinRepositoryImpl
import com.chachadev.appthe.core.domain.repo.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
    @Binds
    @Singleton
    abstract fun bindCoinRepository(coinRepositoryImpl: CoinRepositoryImpl) : CoinRepository
}