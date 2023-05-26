package com.example.parcialtp3.model

data class CarResponse(
    val results:List<Car>
)
data class Car (
    val fuel_type:String,
    val make:String,
    val model:String,
    val transmission:String,
    val year:Int
    // TODO: revisar que atributo es el "Two seater" si fuera class como lo declaro? porque class es una palabra reservada y si no no lo mapea el gson

        )