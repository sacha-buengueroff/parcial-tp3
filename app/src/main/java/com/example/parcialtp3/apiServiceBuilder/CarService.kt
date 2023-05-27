package com.example.parcialtp3.apiServiceBuilder

import com.example.parcialtp3.model.domain.Car
import retrofit2.Call
import retrofit2.http.GET

interface CarService {

    @GET("cars?year=2018")
    //TODO: fijarese como hacer para no poner ningun parametro,
    // por lo pronto el limit por default es 5 , solo limit no me deja ingresar y car solo tampoco
    fun getCarList(): Call<List<Car>>
}