package com.example.parcialtp3.apiServiceBuilder

import com.example.parcialtp3.domain.Car
import retrofit2.Call
import retrofit2.http.GET

interface CarService {

    @GET("cars?make=toyota&make=bmw&make=volkswagen&limit=10")
    //se fija un conjunto de marcas para evitar no tener el logo
    fun getCarList(): Call<List<Car>>
}