package com.kirabium.relayance.di

import com.kirabium.relayance.repository.CustomersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCustomersRepository(): CustomersRepository {
        return CustomersRepository()
    }

}