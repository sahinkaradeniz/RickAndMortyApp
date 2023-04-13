package com.example.data.source

import com.example.common.NetworkResponseState
import com.example.data.datasource.api.RickAndMortyApi
import com.example.data.dto.location.Results
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi
):RemoteDataSource {
    override suspend fun getAllRickAndMortyLocation(pageSize:Int): NetworkResponseState<List<Results>> {
       return try {
           val response=rickAndMortyApi.getRickAndMortyLocation(pageSize)
           NetworkResponseState.Success(response.results)
       }catch (e:Exception){
           NetworkResponseState.Error(e)
       }
    }
}