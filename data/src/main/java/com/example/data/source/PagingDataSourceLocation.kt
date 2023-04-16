package com.example.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.api.RickAndMortyApi
import com.example.data.mapper.RickAndMortLocationMapper
import com.example.domain.entity.LocationEntity
import retrofit2.HttpException
import javax.inject.Inject


class PagingDataSourceLocation @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi,
    private val rickAndMortLocationMapper: RickAndMortLocationMapper,
) : PagingSource<Int, LocationEntity>() {

    override fun getRefreshKey(state: PagingState<Int, LocationEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationEntity> {
        val page = params.key ?: STARTING_PAGE_INDEX
        val pageSize: Int
        return try {
            val apiResult = rickAndMortyApi.getRickAndMortyLocation(page)
            pageSize = apiResult.info.pages
            val response = rickAndMortLocationMapper.map(apiResult.results)
            LoadResult.Page(
                data = response,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (response.isEmpty()) {
                    null
                } else if (page >= pageSize) {
                    null
                } else {
                    page.plus(1)
                }
                /**
                 *  nextKey = if (response.isEmpty()) null else page.plus(1)
                 *  With this method, the requests made after exceeding the number of pages in the api give an http 404 error.
                 *  That's why I checked with the pages data from api info.
                 */
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}