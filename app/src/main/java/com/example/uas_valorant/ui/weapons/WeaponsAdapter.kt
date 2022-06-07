package com.example.uas_valorant.ui.weapons
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter

import com.example.uas_valorant.databinding.ListViewItemBinding
import com.example.uas_valorant.ui.network.DataItem
import com.example.uas_valorant.ui.network.Weapon

class WeaponsAdapter(private val clickListener: WeaponsListener) :
    ListAdapter<DataItem, WeaponsAdapter.WeaponsViewHolder>(DiffCallback)
{
    class WeaponsViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: WeaponsListener, weapons: DataItem){
            binding.weapons = weapons
            binding.clickListener= clickListener
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DataItem>(){
        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.displayName == newItem.displayName
        }

        override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.shopData == newItem.shopData && oldItem.displayIcon == newItem.displayIcon
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : WeaponsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WeaponsViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WeaponsViewHolder, position: Int){
        val weapons = getItem(position)
        holder.bind(clickListener, weapons)
    }
}

class WeaponsListener(val clickListener: (weapons: DataItem ) -> Unit){
    fun onClick(weapons: DataItem) = clickListener(weapons)
}