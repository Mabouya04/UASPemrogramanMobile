package com.example.uas_valorant.ui.weapons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uas_valorant.R
import com.example.uas_valorant.databinding.FragmentWeaponsBinding

class WeaponsFragment : Fragment(){
    private val viewModel: WeaponsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWeaponsBinding.inflate(inflater)
        viewModel.getWeaponList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = WeaponsAdapter(WeaponsListener { weapons ->
            viewModel.onWeaponsClicked(weapons)
            findNavController()
                .navigate(R.id.action_weaponsFragment_to_weaponFragment)
        })
        return binding.root
    }
}