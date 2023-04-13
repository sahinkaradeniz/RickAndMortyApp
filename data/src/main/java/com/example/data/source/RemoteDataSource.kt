package com.example.data.source

import com.example.common.NetworkResponseState
import com.example.data.dto.location.Results

interface RemoteDataSource {
    suspend fun getAllRickAndMortyLocation(pageSize:Int):NetworkResponseState<List<Results>>
}