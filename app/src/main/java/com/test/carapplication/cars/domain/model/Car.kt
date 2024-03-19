package com.test.carapplication.cars.domain.model


data class Car(
    val id: Int,
    val model: Int,
    val plateNumber: String,
    val currency: String,
    val color: String,
    val brand: String,
    val unitPrice: Double,
)
