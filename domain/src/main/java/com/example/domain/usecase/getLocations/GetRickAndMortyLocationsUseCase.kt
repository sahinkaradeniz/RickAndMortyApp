package com.example.domain.usecase.getLocations

import com.example.common.NetworkResult
import com.example.domain.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

interface GetRickAndMortyLocationsUseCase{
    suspend operator fun invoke():NetworkResult<List<LocationEntity>>
}