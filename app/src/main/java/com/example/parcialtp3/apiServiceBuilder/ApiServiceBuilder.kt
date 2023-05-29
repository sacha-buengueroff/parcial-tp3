package com.example.parcialtp3.apiServiceBuilder


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIServicesBuilder {
    private val BASE_URL = "https://api.api-ninjas.com/v1/"
    private val API_KEY = "CCwcToqTmJYBJE9b3lk1zg==ohwzHGciQqeYatVH"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client =
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).addInterceptor { chain ->
                val originalRequest = chain.request()
                val modifiedRequest =
                    originalRequest.newBuilder().header("X-Api-Key", API_KEY).build()
                chain.proceed(modifiedRequest)
            }.build()

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(client)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun create(): CarService {
        return retrofit.create(CarService::class.java)
    }
}