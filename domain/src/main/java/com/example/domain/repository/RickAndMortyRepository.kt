package com.example.domain.repository

import androidx.paging.PagingData
import com.example.common.NetworkResult
import com.example.domain.entity.CharacterEntity
import com.example.domain.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    fun getAllRickAndMortyLocations():Flow<PagingData<LocationEntity>>

    suspend fun getRickAndMortyCharacterWithId(id:String):NetworkResult<CharacterEntity>

    suspend fun getCharactersWithRickAndMortyLocation(urlList:List<String>):NetworkResult<List<CharacterEntity>>
}