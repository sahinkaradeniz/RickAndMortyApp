package com.example.domain.usecase.getLocations

import com.example.common.NetworkResult
import com.example.domain.entity.LocationEntity
import com.example.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetRickAndMortyLocationsUseCaseImpl @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository,
) : GetRickAndMortyLocationsUseCase {
    override suspend fun invoke(): NetworkResult<List<LocationEntity>> {
        return rickAndMortyRepository.getRickAndMortyLocations()
    }

}