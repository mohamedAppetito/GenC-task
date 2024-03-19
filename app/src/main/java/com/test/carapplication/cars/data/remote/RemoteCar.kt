package com.test.carapplication.cars.data.remote

import com.google.gson.annotations.SerializedName


data class RemoteCar(
    val id: Int,
    @SerializedName("model")
    val model: Int,
    @SerializedName("plate_number")
    val plateNumber: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("color")
    val color: String,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("unit_price")
    val unitPrice: Double,
)

