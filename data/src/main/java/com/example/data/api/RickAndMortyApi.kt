package com.example.data.api

import com.example.common.NetworkResult
import com.example.data.dto.character.CharacterResponse
import com.example.data.dto.location.RickAndMortyLocationResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("location")
    suspend fun getRickAndMortyLocation(
        @Query("page") page: Int
    ):RickAndMortyLocationResponse
    @GET("character/{ids}")
    suspend fun getCharactersWithRickAndMortyLocation(
        @Path("ids") ids:String
    ): List<CharacterResponse>
}