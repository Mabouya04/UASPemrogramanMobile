package com.example.uas_valorant

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.uas_valorant.ui.network.DataItem
import com.example.uas_valorant.ui.weapons.ValorantApiStatus
import com.example.uas_valorant.ui.weapons.WeaponsAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<DataItem>?){
    val adapter = recyclerView.adapter as WeaponsAdapter
    adapter.submitList(data)
}

//@BindingAdapter("listDatas")
//fun bindRecyclerViews(recyclerView: RecyclerView, data: List<PotterBukuItem>?){
//    val adapter = recyclerView.adapter as BukuListAdapter
//    adapter.submitList(data)
//}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: ValorantApiStatus?) {
    when(status) {
        ValorantApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ValorantApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        ValorantApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}