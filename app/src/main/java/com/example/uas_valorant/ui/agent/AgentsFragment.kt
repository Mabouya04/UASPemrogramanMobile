package com.example.uas_valorant.ui.agent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uas_valorant.R
import com.example.uas_valorant.databinding.FragmentAgentsBinding
import com.example.uas_valorant.databinding.FragmentWeaponsBinding
import com.example.uas_valorant.ui.agent.AgentsAdapter
import com.example.uas_valorant.ui.agent.AgentsListener
import com.example.uas_valorant.ui.agent.AgentsViewModel

class AgentsFragment : Fragment(){
    private val viewModel: AgentsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAgentsBinding.inflate(inflater)
        viewModel.getAgentList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = AgentsAdapter(AgentsListener { agents ->
            viewModel.onAgentsClicked(agents)
            findNavController()
                .navigate(R.id.action_agentsFragment_to_agentFragment)
        })
        return binding.root
    }
}