package com.test.carapplication.cars.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface CarsApiService {

    @GET("cars.json")
    suspend fun getCars(): List<RemoteCar>

    @GET("cars.json?orderBy=\"id\"")
    suspend fun getCarDetail(@Query("equalTo") id: Int) :Map<String, RemoteCar>
}