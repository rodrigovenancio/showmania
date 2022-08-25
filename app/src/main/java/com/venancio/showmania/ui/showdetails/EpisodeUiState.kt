package com.venancio.showmania.ui.showdetails

import com.venancio.showmania.common.BaseUiState
import com.venancio.showmania.data.model.EpisodeModel
import com.venancio.showmania.data.model.ShowModel

data class EpisodeUiState(private val showModel: EpisodeModel) : BaseUiState() {

    fun getEpisode() = showModel

    fun getEpisodeId() = showModel.id

    fun getEpisodeName() = showModel.name

    fun getSeason() = showModel.season

    fun getNumber() = showModel.number

    fun getMediumImage() = showModel.image.medium

}