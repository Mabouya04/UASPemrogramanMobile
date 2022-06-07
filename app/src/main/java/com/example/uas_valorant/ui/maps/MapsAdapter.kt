package com.example.uas_valorant.ui.maps
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.uas_valorant.databinding.ListViewItem1Binding
import com.example.uas_valorant.databinding.ListViewItemBinding
import com.example.uas_valorant.ui.network.DataItem1
import com.example.uas_valorant.ui.network.Map

class MapsAdapter(private val clickListener: MapsListener) :
    ListAdapter<DataItem1, MapsAdapter.MapsViewHolder>(DiffCallback)
{
    class MapsViewHolder(
        var binding: ListViewItem1Binding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: MapsListener, maps: DataItem1){
            binding.maps = maps
            binding.clickListener= clickListener
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DataItem1>(){
        override fun areItemsTheSame(oldItem: DataItem1, newItem: DataItem1): Boolean {
            return oldItem.displayName == newItem.displayName
        }

        override fun areContentsTheSame(oldItem: DataItem1, newItem: DataItem1): Boolean {
            return oldItem.displayIcon == newItem.displayIcon
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MapsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MapsViewHolder(
            ListViewItem1Binding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MapsViewHolder, position: Int){
        val maps = getItem(position)
        holder.bind(clickListener, maps)
    }
}

class MapsListener(val clickListener: (maps: DataItem1 ) -> Unit){
    fun onClick(maps: DataItem1) = clickListener(maps)
}