package com.example.parcialtp3.domain

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("class") val carClass: String, // Utiliza otro nombre para evitar la palabra reservada "class"
    @SerializedName("fuel_type") val fuelType: String,
    val make: String,
    val model: String,
    val transmission: String,
    val year: Int
)