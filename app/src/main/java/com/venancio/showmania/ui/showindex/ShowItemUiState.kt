package com.venancio.showmania.ui.showindex

import com.venancio.showmania.common.BaseUiState
import com.venancio.showmania.data.model.ShowModel

data class ShowItemUiState(private val showModel: ShowModel) : BaseUiState() {

    fun getShow() = showModel

    fun getShowId() = showModel.id

    fun getShowName() = showModel.name

    fun getLanguage() = showModel.language

    fun getMediumImage() = showModel.image.medium

}