package com.example.domain.usecase.getLocationPaging

import androidx.paging.PagingData
import com.example.domain.entity.LocationEntity
import com.example.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocationPagingDataSourceUseCaseImpl @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
):GetLocationPagingDataSourceUseCase {
    override fun invoke(): Flow<PagingData<LocationEntity>> {
     return rickAndMortyRepository.getAllRickAndMortyLocations()
 }
}