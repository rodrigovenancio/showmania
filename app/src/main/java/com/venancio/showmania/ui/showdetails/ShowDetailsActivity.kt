package com.venancio.showmania.ui.showdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.venancio.showmania.*
import com.venancio.showmania.common.FooterAdapter
import com.venancio.showmania.data.model.EpisodeModel
import com.venancio.showmania.databinding.ActivityShowIndexBinding
import com.venancio.showmania.util.ext.collect
import com.venancio.showmania.util.ext.collectLast
import com.venancio.showmania.util.ext.executeWithAction
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@AndroidEntryPoint
class ShowDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowIndexBinding
    private lateinit var episode: EpisodeModel
//    private val viewModel: ShowIndexViewModel by viewModels()

    companion object {
        const val TAG = "ShowDetailsActivity"
        const val EXTRA_SHOW = "extra_show"
    }

    /*@Inject
    lateinit var showIndexAdapter: ShowIndexAdapter*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        handleExtras()
        /*setListener()
        setAdapter()*/
        //collectLast(viewModel.showIndexUiStates, ::setShowIndex)
    }

    private fun handleExtras() {
        intent.extras?.let { extras ->
           this.episode = extras.getString(EXTRA_SHOW) as EpisodeModel
        }
    }

    private fun setData() {

    }

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_details)
    }

    /*private fun setListener() {
        binding.btnRetry.setOnClickListener { showIndexAdapter.retry() }
    }

    private fun setAdapter() {
        collect(flow = showIndexAdapter.loadStateFlow
            .distinctUntilChangedBy { it.source.refresh }
            .map { it.refresh },
            action = ::setShowIndexUiState
        )
        binding.rvShowIndex.adapter = showIndexAdapter.withLoadStateFooter(FooterAdapter(showIndexAdapter::retry))
        showIndexAdapter.onItemClick = { selectedShow ->

        }
    }

    private fun setShowIndexUiState(loadState: LoadState) {
        binding.executeWithAction {
            showIndexUiState = ShowIndexUiState(loadState)
        }
    }

    private suspend fun setShowIndex(showItemsPagingData: PagingData<ShowItemUiState>) {
        showIndexAdapter.submitData(showItemsPagingData)
    }*/

}