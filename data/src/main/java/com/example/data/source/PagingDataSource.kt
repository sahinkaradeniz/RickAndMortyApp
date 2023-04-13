package com.example.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.datasource.api.RickAndMortyApi
import com.example.data.mapper.RickAndMortLocationMapper
import com.example.domain.dto.LocationEntity
import javax.inject.Inject


class PagingDataSource @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi,
    private val rickAndMortLocationMapper: RickAndMortLocationMapper
) : PagingSource<Int, LocationEntity>() {
    override fun getRefreshKey(state: PagingState<Int,LocationEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationEntity> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = rickAndMortyApi.getRickAndMortyLocation(page)
            LoadResult.Page(
                data = rickAndMortLocationMapper.map(response.results),
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (response.results.isEmpty()) null else page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}