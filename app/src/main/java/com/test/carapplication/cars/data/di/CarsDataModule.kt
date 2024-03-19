package com.test.carapplication.cars.data.di

import com.test.carapplication.cars.data.remote.CarsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CarsDataModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://gene-cars-default-rtdb.firebaseio.com/")
            .build()

    @Provides
    fun provideApiServices(retrofit: Retrofit): CarsApiService =
        retrofit.create(CarsApiService::class.java)

}