package com.example.data.source

import com.example.common.NetworkResult
import com.example.common.ResultError
import com.example.data.api.RickAndMortyApi
import com.example.data.dto.character.CharacterResponse
import com.example.data.dto.location.Results
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi
):RemoteDataSource {
    override suspend fun getAllRickAndMortyLocation(pageSize:Int): NetworkResult<List<Results>> {
       return try {
           NetworkResult.Success(rickAndMortyApi.getRickAndMortyLocation(pageSize).results)
       }catch (e: IOException){
           NetworkResult.Error.IOException(
               ResultError(
                   errorMessage = e.localizedMessage ?: ""
               )
           )
       }catch (e:HttpException){
           NetworkResult.Error.ApiError(
               ResultError(
                   errorMessage = e.localizedMessage ?: ""
               )
           )
       }
    }

    override suspend fun getCharactersWithRickAndMortyLocation(ids: String): NetworkResult<List<CharacterResponse>> {
        return try {
           NetworkResult.Success(rickAndMortyApi.getCharactersWithRickAndMortyLocation(ids))
        }catch (e: IOException){
            NetworkResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }catch (e:HttpException){
            NetworkResult.Error.ApiError(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }
}