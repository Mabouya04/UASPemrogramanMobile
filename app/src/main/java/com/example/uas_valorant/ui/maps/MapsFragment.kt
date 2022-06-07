package com.example.uas_valorant.ui.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uas_valorant.R
import com.example.uas_valorant.databinding.FragmentMapsBinding

class MapsFragment : Fragment(){
    private val viewModel: MapsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMapsBinding.inflate(inflater)
        viewModel.getMapList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = MapsAdapter(MapsListener { maps ->
            viewModel.onMapsClicked(maps)
            findNavController()
                .navigate(R.id.action_mapsFragment_to_mapFragment)
        })
        return binding.root
    }
}