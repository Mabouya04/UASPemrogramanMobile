package com.example.uas_valorant.ui.agent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.uas_valorant.R
import com.example.uas_valorant.databinding.FragmentAgentBinding
import com.example.uas_valorant.databinding.FragmentWeaponBinding
import com.example.uas_valorant.ui.weapons.WeaponsViewModel

class AgentFragment : Fragment() {

    private val viewModel : AgentsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstancesState: Bundle?
    ): View? {
        val binding = FragmentAgentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> findNavController().navigate(R.id.action_agentsFragment_to_agentFragment)
        }
        return true
    }
}