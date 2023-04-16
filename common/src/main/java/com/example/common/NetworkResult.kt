package com.example.common

import java.io.IOException

sealed interface NetworkResult<out T> {

    data class Success<T>(val data: T?) : NetworkResult<T>

    sealed interface Error<T> : NetworkResult<T> {
        val error: ResultError

        data class IOException<T>(override val error: ResultError) : Error<T>

        data class InternetUnavailableException<T>(
            override val error: ResultError
        ) : Error<T>

        data class ApiError<T>(override val error: ResultError) : Error<T>

    }
}

inline fun <T> NetworkResult<T>.onSuccess(handler: (T?) -> Unit): NetworkResult<T> =
    this.also {
        if (this is NetworkResult.Success)
            handler(data)
    }

inline fun <T> NetworkResult<T>.onError(handler: (NetworkResult.Error<T>?) -> Unit): NetworkResult<T> =
    this.also {
        if (this is NetworkResult.Error)
            handler(this)
    }

data class ResultError(val errorMessage: String?, val errorCode: Int? = null)

class NetworkUnavailableException : IOException()