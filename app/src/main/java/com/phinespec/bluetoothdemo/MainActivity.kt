package com.phinespec.bluetoothdemo

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.phinespec.bluetoothdemo.databinding.ActivityMainBinding
import com.phinespec.bluetoothdemo.util.BluetoothService
import com.phinespec.bluetoothdemo.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.btnToggleEnabled.setOnClickListener {
            if (!BluetoothService.isAdapterEnabled()) {
                val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.BLUETOOTH_CONNECT
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                }
                startActivity(intent)
            }
        }
    }
}