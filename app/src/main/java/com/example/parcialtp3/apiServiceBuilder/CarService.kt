package com.example.parcialtp3.apiServiceBuilder

import com.example.parcialtp3.model.domain.Car
import retrofit2.Call
import retrofit2.http.GET

interface CarService {

    @GET("cars?make=audi&make=renault&make=ford&limit=10")
    //TODO: se fija un conjunto de marcas para evitar no tener el logo
    fun getCarList(): Call<List<Car>>
}