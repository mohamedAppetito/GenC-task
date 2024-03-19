package com.test.carapplication.cars.data.mapper

import com.test.carapplication.cars.data.remote.RemoteCar
import com.test.carapplication.cars.domain.model.Car


fun RemoteCar.toCar()= Car(
    id=id,
    plateNumber =plateNumber,
    unitPrice=unitPrice,
    model=model,
    currency = currency,
    color = color,
    brand = brand
)