package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.datasource.api.RickAndMortyApi
import com.example.data.mapper.RickAndMortLocationMapper
import com.example.data.source.PagingDataSource
import com.example.domain.dto.LocationEntity
import com.example.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi,
    private val rickAndMortLocationMapper: RickAndMortLocationMapper,
) : RickAndMortyRepository {
    override suspend fun getAllRickAndMortyLocations(): Flow<PagingData<LocationEntity>> {
        return Pager(
                config = PagingConfig(
                    pageSize = NETWORK_PAGE_SIZE
                ),
                pagingSourceFactory = { PagingDataSource(rickAndMortyApi,rickAndMortLocationMapper) }
            ).flow
        }
    companion object {
        const val NETWORK_PAGE_SIZE= 20
    }
}