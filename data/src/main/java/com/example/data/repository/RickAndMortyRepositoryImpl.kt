package com.example.data.repository

import com.example.common.NetworkResponseState
import com.example.data.di.coroutine.IoDispatcher
import com.example.data.mapper.RickAndMortLocationMapper
import com.example.data.source.RemoteDataSource
import com.example.domain.dto.LocationEntity
import com.example.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val rickAndMortLocationMapper: RickAndMortLocationMapper,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : RickAndMortyRepository {
    override suspend fun getAllRickAndMortyLocations(): NetworkResponseState<List<LocationEntity>> =
        withContext(ioDispatcher) {
            when (val response = remoteDataSource.getAllRickAndMortyLocation(locationPage)) {
                is NetworkResponseState.Error -> NetworkResponseState.Error(response.exception)
                is NetworkResponseState.Success -> NetworkResponseState.Success(
                    rickAndMortLocationMapper.map(response.result!!)
                )
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
            }
        }

    companion object {
        const val locationPage = 1
    }

}