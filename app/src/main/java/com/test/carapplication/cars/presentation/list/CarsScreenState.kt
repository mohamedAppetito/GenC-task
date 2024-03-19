package com.test.carapplication.cars.presentation.list

import com.test.carapplication.cars.domain.model.Car

data class CarsScreenState(
    val cars : List<Car>,
    val isLoading : Boolean,
    val error : String?=null
)
