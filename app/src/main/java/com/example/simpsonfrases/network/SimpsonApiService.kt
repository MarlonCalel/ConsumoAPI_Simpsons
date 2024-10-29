package com.example.simpsonfrases.network

import com.example.simpsonfrases.models.PersonajesSimpsons
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpsonApiService {
    @GET("quotes?count=50")
    suspend fun obtenerPersonajes(): Response<List<PersonajesSimpsons>>

    @GET("quotes")
    suspend fun obtenerPersonajes(
        @Query("character") personaje: String
    ): Response<List<PersonajesSimpsons>>
}