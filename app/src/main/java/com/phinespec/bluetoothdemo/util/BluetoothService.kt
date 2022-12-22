package com.phinespec.bluetoothdemo.util

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import androidx.core.app.ActivityCompat.startActivityForResult

object BluetoothService {

    const val REQUEST_CODE_ENABLE_BT = 1

    val adapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

    fun isAdapterEnabled(): Boolean = adapter.isEnabled
}