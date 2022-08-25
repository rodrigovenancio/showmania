package com.venancio.showmania.data.repository

import androidx.paging.PagingData
import com.venancio.showmania.data.model.ShowModel
import kotlinx.coroutines.flow.Flow

interface ShowRepository {
    fun getShowIndex(): Flow<PagingData<ShowModel>>
}