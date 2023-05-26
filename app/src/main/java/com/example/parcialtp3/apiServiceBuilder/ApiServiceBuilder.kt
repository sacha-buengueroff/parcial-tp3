package com.example.parcialtp3.apiServiceBuilder

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIServicesBuilder {
    private val BASE_URL= "https://api.api-ninjas.com/v1"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): CarService{
        return retrofit.create(CarService::class.java)
    }
}