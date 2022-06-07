package com.example.uas_valorant.ui.agent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter

import com.example.uas_valorant.databinding.ListAgentsItemBinding
import com.example.uas_valorant.ui.network.DataItems
import com.example.uas_valorant.ui.network.Agent

class AgentsAdapter(private val clickListener: AgentsListener) :
    ListAdapter<DataItems, AgentsAdapter.AgentsViewHolder>(DiffCallback)
{
    class AgentsViewHolder(
        var binding: ListAgentsItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: AgentsListener, agents: DataItems){
            binding.agents = agents
            binding.clickListener= clickListener
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DataItems>(){
        override fun areItemsTheSame(oldItem: DataItems, newItem: DataItems): Boolean {
            return oldItem.displayName == newItem.displayName
        }

        override fun areContentsTheSame(oldItem: DataItems, newItem: DataItems): Boolean {
            return oldItem.role == newItem.role && oldItem.displayIcon == newItem.displayIcon
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : AgentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AgentsViewHolder(
            ListAgentsItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AgentsViewHolder, position: Int){
        val agents = getItem(position)
        holder.bind(clickListener, agents)
    }
}

class AgentsListener(val clickListener: (agents: DataItems ) -> Unit){
    fun onClick(agents: DataItems) = clickListener(agents)
}