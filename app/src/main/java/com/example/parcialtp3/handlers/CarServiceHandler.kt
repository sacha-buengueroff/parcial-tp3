package com.example.parcialtp3.handlers

import com.example.parcialtp3.apiServiceBuilder.APIServicesBuilder
import com.example.parcialtp3.model.domain.Car
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarServiceHandler {

    lateinit var listCarResponse: Response<List<Car>>

     suspend operator fun invoke(): List<Car>{
         val service = APIServicesBuilder.create()
         service.getCarList().enqueue(object: Callback<List<Car>> {
             override fun onResponse(
                 call: Call<List<Car>>,
                 response: Response<List<Car>>
             ){
                 println("Parada 4")
                 listCarResponse = response
                 println(response.body()!!)
             }
             override fun onFailure(call: Call<List<Car>>, t: Throwable) {
                 println(t.message)
             }
         })
         //El operador Elvis ?: se utiliza para proporcionar un valor de respaldo en caso de que la expresión a su izquierda sea nula.
         return listCarResponse.body() ?: emptyList()
     }
}