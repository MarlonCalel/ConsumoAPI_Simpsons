package com.example.simpsonfrases.core

import com.example.simpsonfrases.network.SimpsonApiService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val simpsonapiservice: SimpsonApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(SimpsonApiService::class.java)
    }
}