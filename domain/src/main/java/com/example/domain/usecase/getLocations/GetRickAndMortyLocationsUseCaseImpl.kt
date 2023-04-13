package com.example.domain.usecase.getLocations

import androidx.paging.PagingData
import com.example.common.NetworkResponseState
import com.example.domain.dto.LocationEntity
import com.example.domain.repository.RickAndMortyRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetRickAndMortyLocationsUseCaseImpl @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
):GetRickAndMortyLocationsUseCase {
    override suspend fun invoke(): Flow<PagingData<LocationEntity>> {
        return rickAndMortyRepository.getAllRickAndMortyLocations()
    }
}