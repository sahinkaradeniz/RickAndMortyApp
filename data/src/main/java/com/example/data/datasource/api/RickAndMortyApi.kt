package com.example.data.datasource.api

import com.example.data.dto.location.RickAndMortyLocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("location")
    suspend fun getRickAndMortyLocation(
        @Query("page") page: Int
    ):RickAndMortyLocationResponse
}