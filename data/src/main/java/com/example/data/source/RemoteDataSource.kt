package com.example.data.source

import com.example.common.NetworkResult
import com.example.data.dto.character.CharacterResponse
import com.example.data.dto.location.Results


interface RemoteDataSource {
    suspend fun getAllRickAndMortyLocation(pageSize:Int):NetworkResult<List<Results>>
    suspend fun getCharactersWithRickAndMortyLocation(ids:String): NetworkResult<List<CharacterResponse>>
    suspend fun getCharacterWithID(id:String):NetworkResult<CharacterResponse>
}