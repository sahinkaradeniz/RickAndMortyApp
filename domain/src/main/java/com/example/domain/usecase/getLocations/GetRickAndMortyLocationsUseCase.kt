package com.example.domain.usecase.getLocations

import androidx.paging.PagingData
import com.example.domain.dto.LocationEntity
import kotlinx.coroutines.flow.Flow

interface GetRickAndMortyLocationsUseCase{
    suspend operator fun invoke():Flow<PagingData<LocationEntity>>
}