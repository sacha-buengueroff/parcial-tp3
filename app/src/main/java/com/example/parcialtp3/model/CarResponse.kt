package com.example.parcialtp3.model

data class CarResponse(
    val results:List<Car>
)
data class Car (
    val model:String,
    val make:String,
    val transmission:String,
    val fuel_type:String,
    val year:Int
    // TODO: revisar que atributo es el "Two seater" si fuera class como lo declaro?

        )