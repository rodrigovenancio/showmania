package com.venancio.showmania.data.repository

import androidx.paging.PagingData
import com.venancio.showmania.data.model.ShowModel
import kotlinx.coroutines.flow.Flow

interface EpisodeRepository {
    fun getIndex(showId: Long): Flow<PagingData<ShowModel>>
}