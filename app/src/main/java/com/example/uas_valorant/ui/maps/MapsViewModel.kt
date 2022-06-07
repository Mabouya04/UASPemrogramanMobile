package com.example.uas_valorant.ui.maps

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_valorant.ValorantApi
import com.example.uas_valorant.ValorantApi1
import com.example.uas_valorant.ui.network.dataItem
import com.example.uas_valorant.ui.network.Map
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.launch
import java.lang.Exception

enum class ValorantApiStatus { LOADING, ERROR, DONE }

class MapsViewModel : ViewModel() {
    private val _status = MutableLiveData<ValorantApiStatus>()
    val status: LiveData<ValorantApiStatus> = _status

    private val _maps = MutableLiveData<List<dataItem>>()
    val maps: LiveData<List<dataItem>> = _maps

    private val _map = MutableLiveData<dataItem>()
    val map: LiveData<dataItem> = _map

    fun getMapList() {
        viewModelScope.launch {
            _status.value = ValorantApiStatus.LOADING
            try {
                _maps.value = ValorantApi1.retrofitValorantApi1.getListMaps().await().data!!
                _status.value = ValorantApiStatus.DONE
            } catch (e: Exception) {
                _maps.value = listOf()
                _status.value = ValorantApiStatus.ERROR
                Log.e("Pesan Error :", "${e.message}")
            }
        }
    }

    fun onMapsClicked(maps: dataItem) {
        _map.value = maps
    }


}