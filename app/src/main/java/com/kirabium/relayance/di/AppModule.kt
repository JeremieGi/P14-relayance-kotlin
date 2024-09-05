package com.kirabium.relayance.di

import com.kirabium.relayance.repository.CustomerFakeAPI
import com.kirabium.relayance.repository.ICustomerAPI
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
    fun provideICustomerAPI(): ICustomerAPI {
        return CustomerFakeAPI()
    }


}