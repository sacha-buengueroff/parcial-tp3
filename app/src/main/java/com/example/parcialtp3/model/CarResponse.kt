package com.example.parcialtp3.model

import com.google.gson.annotations.SerializedName

data class CarResponse(
    val results:List<Car>
)
data class Car (
    @SerializedName("class") val carClass: String, // Utiliza otro nombre para evitar la palabra reservada "class"
    val fuel_type:String,
    val make:String,
    val model:String,
    val transmission:String,
    val year:Int
        )