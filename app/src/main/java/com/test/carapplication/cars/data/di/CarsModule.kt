package com.test.carapplication.cars.data.di

import com.test.carapplication.cars.data.repository.CarsRepositoryImpl
import com.test.carapplication.cars.domain.repository.CarsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CarsModule {
    @Binds
    abstract fun bindComicsRepository(imp: CarsRepositoryImpl): CarsRepository
}