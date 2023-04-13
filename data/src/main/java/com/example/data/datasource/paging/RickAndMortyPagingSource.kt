package com.example.data.datasource.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.datasource.api.RickAndMortyApi
import com.example.data.dto.location.Results
import javax.inject.Inject


class RickAndMortyPagingSource  @Inject constructor(private val rickAndMortyApi: RickAndMortyApi):PagingSource<Int, Results>(){
    override fun getRefreshKey(state: PagingState<Int, Results>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response=rickAndMortyApi.getRickAndMortyLocation(page)
            LoadResult.Page(
                data = response.results,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (response.results.isEmpty()) null else page.plus(1)
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}