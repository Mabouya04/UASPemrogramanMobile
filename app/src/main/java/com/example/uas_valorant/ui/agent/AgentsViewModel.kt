package com.example.uas_valorant.ui.agent

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_valorant.ValorantApi
import com.example.uas_valorant.ValorantsApi
import com.example.uas_valorant.ui.network.DataItems
import kotlinx.coroutines.launch
import java.lang.Exception

enum class ValorantsApiStatus { LOADING, ERROR, DONE }

class AgentsViewModel : ViewModel() {
    private val _status = MutableLiveData<ValorantsApiStatus>()
    val status: LiveData<ValorantsApiStatus> = _status

    private val _agents = MutableLiveData<List<DataItems>>()
    val agents: LiveData<List<DataItems>> = _agents

    private val _agent = MutableLiveData<DataItems>()
    val agent: LiveData<DataItems> = _agent

    fun getAgentList() {
        viewModelScope.launch {
            _status.value = ValorantsApiStatus.LOADING
            try {
                _agents.value = ValorantsApi.retrofitValorantsApi.getListAgents().await().data!!
                _status.value = ValorantsApiStatus.DONE
            } catch (e: Exception) {
                _agents.value = listOf()
                _status.value = ValorantsApiStatus.ERROR
                Log.e("Pesan Error :", "${e.message}")
            }
        }
    }

    fun onAgentsClicked(agents: DataItems) {
        _agent.value = agents
    }
}