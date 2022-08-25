package com.venancio.showmania.ui.showindex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.google.gson.Gson
import com.venancio.showmania.*
import com.venancio.showmania.common.FooterAdapter
import com.venancio.showmania.databinding.ActivityShowIndexBinding
import com.venancio.showmania.ui.showdetails.ShowDetailsActivity
import com.venancio.showmania.util.ext.collect
import com.venancio.showmania.util.ext.collectLast
import com.venancio.showmania.util.ext.executeWithAction
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@AndroidEntryPoint
class ShowIndexActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowIndexBinding
    private val viewModel: ShowIndexViewModel by viewModels()

    @Inject
    lateinit var showIndexAdapter: ShowIndexAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setListener()
        setAdapter()
        collectLast(viewModel.showIndexUiStates, ::setShowIndex)
    }

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_index)
    }

    private fun setListener() {
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
            val gson = Gson()
            val showJson = gson.toJson(selectedShow)
            val intent = Intent(this, ShowDetailsActivity::class.java)
            intent.putExtra(ShowDetailsActivity.EXTRA_SHOW, showJson)
            startActivity(intent)
        }
    }

    private fun setShowIndexUiState(loadState: LoadState) {
        binding.executeWithAction {
            showIndexUiState = ShowIndexUiState(loadState)
        }
    }

    private suspend fun setShowIndex(showItemsPagingData: PagingData<ShowItemUiState>) {
        showIndexAdapter.submitData(showItemsPagingData)
    }

}