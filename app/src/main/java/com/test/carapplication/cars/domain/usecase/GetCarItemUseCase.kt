package com.test.carapplication.cars.domain.usecase

import com.test.carapplication.cars.domain.repository.CarsRepository
import com.test.carapplication.cars.domain.model.Car
import javax.inject.Inject

class GetCarItemUseCase @Inject constructor(
    private val carsRepository: CarsRepository,
) {
    suspend operator fun invoke(id: Int): Car {
       return carsRepository.getCarItem(id)
    }
}