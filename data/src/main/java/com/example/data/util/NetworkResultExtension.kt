package com.example.data.util

import com.example.common.NetworkResult
import com.example.common.mapper.Mapper

internal fun<T, D> NetworkResult<T>.toDomain(mapper: Mapper<T, D>) : NetworkResult<D> {
    return when(this) {
        is NetworkResult.Success -> toDomain(mapper)
        is NetworkResult.Error -> toDomain<T, D>()
    }
}

private fun <T, D> NetworkResult.Error<T>.toDomain() : NetworkResult.Error<D> {
    return when (this) {
        is NetworkResult.Error.IOException -> NetworkResult.Error.IOException<D>(
            this.error
        )

        is NetworkResult.Error.InternetUnavailableException -> NetworkResult.Error.InternetUnavailableException<D>(
            this.error
        )

        is NetworkResult.Error.ApiError -> NetworkResult.Error.ApiError<D>(
            this.error
        )
    }
}

private fun <T, D> NetworkResult.Success<T>.toDomain(mapper: Mapper<T, D>) : NetworkResult.Success<D> {
    return NetworkResult.Success<D>(
        data = mapper.map(this.data!!)
    )
}