package com.example.domain.usecase.getLocations

import com.example.common.NetworkResponseState
import com.example.domain.dto.LocationEntity
import com.example.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetRickAndMortyLocationsUseCaseImpl @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
):GetRickAndMortyLocationsUseCase {
    override suspend fun invoke(): NetworkResponseState<List<LocationEntity>> {
        return rickAndMortyRepository.getAllRickAndMortyLocations()
    }
}