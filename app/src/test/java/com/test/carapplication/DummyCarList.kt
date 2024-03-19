package com.test.carapplication

import com.test.carapplication.cars.data.remote.RemoteCar
import com.test.carapplication.cars.domain.model.Car

object DummyCarList {
    fun getDummyList() = arrayListOf<RemoteCar>(
        RemoteCar(
            id = 1,
            model = 2020,
            color = "RED",
            currency = "EGP",
            plateNumber = "ABC 123",
            unitPrice = 30.5,
            brand = "Honda"
        ),
        RemoteCar(
            id = 1,
            model = 2020,
            color = "RED",
            currency = "EGP",
            plateNumber = "ABC 123",
            unitPrice = 30.5,
            brand = "Honda"
        ),
        RemoteCar(
            id = 1,
            model = 2020,
            color = "RED",
            currency = "EGP",
            plateNumber = "ABC 123",
            unitPrice = 30.5,
            brand = "Honda"
        ),
        RemoteCar(
            id = 1,
            model = 2020,
            color = "RED",
            currency = "EGP",
            plateNumber = "ABC 123",
            unitPrice = 30.5,
            brand = "Honda"
        ),
    )

    fun getDummyCarList() = arrayListOf<Car>(
        Car(
            id = 1,
            model = 2020,
            color = "RED",
            currency = "EGP",
            plateNumber = "ABC 123",
            unitPrice = 30.5,
            brand = "Honda"
        ),
        Car(
            id = 1,
            model = 2020,
            color = "RED",
            currency = "EGP",
            plateNumber = "ABC 123",
            unitPrice = 30.5,
            brand = "Honda"
        ),
        Car(
            id = 1,
            model = 2020,
            color = "RED",
            currency = "EGP",
            plateNumber = "ABC 123",
            unitPrice = 30.5,
            brand = "Honda"
        ),
        Car(
            id = 1,
            model = 2020,
            color = "RED",
            currency = "EGP",
            plateNumber = "ABC 123",
            unitPrice = 30.5,
            brand = "Honda"
        ),
    )
}