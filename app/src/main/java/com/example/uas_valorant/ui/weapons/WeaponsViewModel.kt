package com.example.uas_valorant.ui.weapons

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_valorant.ValorantApi
import com.example.uas_valorant.ui.network.DataItem
import com.example.uas_valorant.ui.network.Weapon
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.launch
import java.lang.Exception

enum class ValorantApiStatus { LOADING, ERROR, DONE }

class WeaponsViewModel : ViewModel() {
    private val _status = MutableLiveData<ValorantApiStatus>()
    val status: LiveData<ValorantApiStatus> = _status

    private val _weapons = MutableLiveData<List<DataItem>>()
    val weapons: LiveData<List<DataItem>> = _weapons

    private val _weapon = MutableLiveData<DataItem>()
    val weapon: LiveData<DataItem> = _weapon

    fun getWeaponList() {
        viewModelScope.launch {
            _status.value = ValorantApiStatus.LOADING
            try {
                _weapons.value = ValorantApi.retrofitValorantApi.getListWeapons().await().data!!
                _status.value = ValorantApiStatus.DONE
            } catch (e: Exception) {
                _weapons.value = listOf()
                _status.value = ValorantApiStatus.ERROR
                Log.e("Pesan Error :", "${e.message}")
            }
        }
    }

    fun onWeaponsClicked(weapons: DataItem) {
        _weapon.value = weapons
    }


}