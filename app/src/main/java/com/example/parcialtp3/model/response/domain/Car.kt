package com.example.parcialtp3.model.response.domain

import com.google.gson.annotations.SerializedName

data class Car (
    @SerializedName("class") val carClass: String, // Utiliza otro nombre para evitar la palabra reservada "class"
    val fuel_type:String,
    val make:String,
    val model:String,
    val transmission:String,
    val year:Int
)