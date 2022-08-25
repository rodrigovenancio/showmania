package com.venancio.showmania.ui.showindex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.venancio.showmania.R
import com.venancio.showmania.data.model.ShowModel
import com.venancio.showmania.databinding.AdapterItemShowBinding
import com.venancio.showmania.util.ext.executeWithAction
import javax.inject.Inject

class ShowIndexAdapter @Inject constructor() :
    PagingDataAdapter<ShowItemUiState, ShowIndexAdapter.ShowViewHolder>(Comparator) {

    var onItemClick: ((ShowModel) -> Unit)? = null

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        getItem(position)?.let { showItemUiState -> holder.bind(showItemUiState) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {

        val binding = inflate<AdapterItemShowBinding>(
            LayoutInflater.from(parent.context),
            R.layout.adapter_item_show,
            parent,
            false
        )

        return ShowViewHolder(binding)
    }

    object Comparator : DiffUtil.ItemCallback<ShowItemUiState>() {
        override fun areItemsTheSame(oldItem: ShowItemUiState, newItem: ShowItemUiState): Boolean {
            return oldItem.getShowId() == newItem.getShowId()
        }

        override fun areContentsTheSame(
            oldItem: ShowItemUiState,
            newItem: ShowItemUiState
        ): Boolean {
            return oldItem == newItem
        }
    }

    inner class ShowViewHolder(private val binding: AdapterItemShowBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let {
                        showItemUiState -> onItemClick?.invoke(showItemUiState.getShow())
                }
            }
        }

        fun bind(showItemUiState: ShowItemUiState) {
            binding.executeWithAction {
                this.showItemUiState = showItemUiState
            }
        }
    }

}