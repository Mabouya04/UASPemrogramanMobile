package com.example.uas_valorant.ui.maps
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.uas_valorant.databinding.ListViewItemBinding
import com.example.uas_valorant.ui.network.dataItem
import com.example.uas_valorant.ui.network.Map

class MapsAdapter(private val clickListener: MapsListener) :
    ListAdapter<dataItem, MapsAdapter.MapsViewHolder>(DiffCallback)
{
    class MapsViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: MapsListener, maps: dataItem){
            binding.maps = maps
            binding.clickListener= clickListener
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<dataItem>(){
        override fun areItemsTheSame(oldItem: dataItem, newItem: dataItem): Boolean {
            return oldItem.displayName == newItem.displayName
        }

        override fun areContentsTheSame(oldItem: dataItem, newItem: dataItem): Boolean {
            return oldItem.displayIcon == newItem.displayIcon
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MapsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MapsViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MapsViewHolder, position: Int){
        val maps = getItem(position)
        holder.bind(clickListener, maps)
    }
}

class MapsListener(val clickListener: (maps: dataItem ) -> Unit){
    fun onClick(maps: dataItem) = clickListener(maps)
}