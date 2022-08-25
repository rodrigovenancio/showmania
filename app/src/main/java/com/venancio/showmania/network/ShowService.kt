package com.venancio.showmania.network

import com.venancio.showmania.data.model.ShowModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ShowService {

    @GET("shows")
    suspend fun getShowIndex(
        @Query("page") page: Int
    ): ArrayList<ShowModel>

}