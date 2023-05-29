package com.example.parcialtp3.domain

import com.google.gson.annotations.SerializedName

data class Marca (
    val marca: String, // Utiliza otro nombre para evitar la palabra reservada "class"
    val amount:String,
    val make:String
)