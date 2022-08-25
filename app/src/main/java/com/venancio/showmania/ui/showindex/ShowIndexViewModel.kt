package com.venancio.showmania.ui.showindex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.venancio.showmania.data.repository.ShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ShowIndexViewModel @Inject constructor(showRepository: ShowRepository) : ViewModel() {
    val showIndexUiStates = showRepository.getShowIndex()
        .map { pagingData ->
            pagingData.map { showModel -> ShowItemUiState(showModel) }
        }.cachedIn(viewModelScope)
}