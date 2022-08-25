package com.venancio.showmania.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.venancio.showmania.network.ShowService
import com.venancio.showmania.data.model.ShowModel
import com.venancio.showmania.data.pagingdatasource.ShowIndexPagingDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShowRepositoryImpl @Inject constructor(
    private val showService: ShowService
) : ShowRepository {
    override fun getShowIndex(): Flow<PagingData<ShowModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE
            ),
            pagingSourceFactory = { ShowIndexPagingDataSource(showService) }
        ).flow
    }


    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }
}