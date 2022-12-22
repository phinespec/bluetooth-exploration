package com.phinespec.bluetoothdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phinespec.bluetoothdemo.util.BluetoothService

class MainViewModel : ViewModel() {

    private val _btIsAvailable = MutableLiveData<Boolean>(false)
    val btIsAvailable: LiveData<Boolean> = _btIsAvailable

    private val _btIsActive = MutableLiveData<Boolean>(BluetoothService.adapter.isEnabled)
    val btIsActive: LiveData<Boolean> = _btIsActive

    fun toggleBt() {
        if (_btIsActive.value != null) {
            _btIsActive.value = !_btIsActive.value!!
        }
    }
}