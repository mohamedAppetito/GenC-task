package com.test.carapplication.cars.domain.repository

import com.test.carapplication.cars.domain.model.Car

interface CarsRepository {
    suspend fun getCarsList(): List<Car>
    suspend fun getCarItem(id: Int): Car
}