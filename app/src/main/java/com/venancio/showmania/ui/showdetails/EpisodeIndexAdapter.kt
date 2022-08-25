package com.venancio.showmania.ui.showdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.venancio.showmania.R
import com.venancio.showmania.data.model.EpisodeModel

class ServiceListAdapter(
    episodeList: List<EpisodeModel>,
    context: Context,
    private val itemSelectedListener: ItemSelectedListener
) :
    RecyclerView.Adapter<ServiceListAdapter.ViewHolder>() {

    private val episodeList: List<EpisodeModel> = episodeList
    private val context: Context = context

    interface ItemSelectedListener{
        fun onItemSelected(episode: EpisodeModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_item_episode,
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val episode = episodeList[position]
        holder.tvShowName.text = episode.name
        holder.tvSeason.text = context.getString(R.string.season_number, episode.season)
        /*holder.parentLayout.setOnClickListener {
            itemSelectedListener.onItemSelected(planning)
        }*/
    }

    override fun getItemCount(): Int {
        return episodeList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvShowName: TextView = view.findViewById<View>(R.id.tvShowName) as TextView
        var tvSeason: TextView = view.findViewById<View>(R.id.tvSeason) as TextView
    }

}