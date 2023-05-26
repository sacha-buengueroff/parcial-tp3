package com.example.parcialtp3.apiServiceBuilder

import com.example.parcialtp3.model.CarResponse
import retrofit2.Call
import retrofit2.http.GET

interface CarService {

    @GET("/cars")
    fun getPokemonList(): Call<CarResponse>
}