package com.venancio.showmania.network

import com.venancio.showmania.data.model.ShowModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeService {

    @GET("shows/{id}/episodes")
    suspend fun getIndex(@Path("id") showId: Long): ArrayList<ShowModel>

}