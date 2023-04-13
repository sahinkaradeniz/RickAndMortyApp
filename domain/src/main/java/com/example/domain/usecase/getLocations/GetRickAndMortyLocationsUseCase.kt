package com.example.domain.usecase.getLocations

import com.example.common.NetworkResponseState
import com.example.domain.dto.LocationEntity

interface GetRickAndMortyLocationsUseCase{
    suspend operator fun invoke():NetworkResponseState<List<LocationEntity>>
}