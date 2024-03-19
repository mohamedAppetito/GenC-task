package com.test.carapplication

import com.test.carapplication.cars.domain.model.Car

object DummyCarList {
    fun getDummyList() = arrayListOf<Car>(
        Car(
            id = 0,
            model = 2020,
            color = "n0",
            currency = "EGP",
            plateNumber = "ABC 123",
            unitPrice = 30.5,
            brand = "Honda"
        ),
        Car(
            id = 2,
            model = 2022,
            color = "REDd",
            currency = "EGPd",
            plateNumber = "ABC 12d3",
            unitPrice = 30.55,
            brand = "Hondffa"
        ),

    )
}