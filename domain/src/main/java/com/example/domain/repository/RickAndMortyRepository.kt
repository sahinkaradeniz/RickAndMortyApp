package com.example.domain.repository

import com.example.common.NetworkResponseState
import com.example.domain.dto.LocationEntity

interface RickAndMortyRepository {
    suspend fun getAllRickAndMortyLocations():NetworkResponseState<List<LocationEntity>>
}