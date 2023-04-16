package com.example.domain.usecase.getLocationPaging

import androidx.paging.PagingData
import com.example.domain.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

interface GetLocationPagingDataSourceUseCase {
    operator fun invoke(): Flow<PagingData<LocationEntity>>
}