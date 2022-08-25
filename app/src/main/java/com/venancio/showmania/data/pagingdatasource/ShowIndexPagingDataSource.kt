package com.venancio.showmania.data.pagingdatasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.venancio.showmania.network.ShowService
import com.venancio.showmania.data.model.ShowModel

class ShowIndexPagingDataSource(private val showService: ShowService) :
    PagingSource<Int, ShowModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ShowModel> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = showService.getShowIndex(page)
            LoadResult.Page(
                data = response,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (response.isEmpty()) null else page.plus(1)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ShowModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 0
    }

}