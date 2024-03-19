package com.test.carapplication.cars.data.repository


import com.test.carapplication.cars.data.di.IoDispatcher
import com.test.carapplication.cars.data.mapper.toCar
import com.test.carapplication.cars.data.remote.CarsApiService
import com.test.carapplication.cars.domain.model.Car
import com.test.carapplication.cars.domain.repository.CarsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(
    private val api: CarsApiService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : CarsRepository {

    override suspend fun getCarsList(): List<Car> = withContext(dispatcher) {
        try {
            api.getCars().map { it.toCar() }
        }catch (t: Throwable) {
            throw Exception("try connecting to internet")
        }
    }

    override suspend fun getCarItem(id :Int): Car = withContext(dispatcher) {
        try {
            api.getCarDetail(id).values.first().let { it.toCar() }
        }catch (t: Throwable) {
            throw Exception("try connecting to internet")
        }
    }
}