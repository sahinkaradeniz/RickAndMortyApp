package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.dto.LocationEntity
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    suspend fun getAllRickAndMortyLocations():Flow<PagingData<LocationEntity>>
}