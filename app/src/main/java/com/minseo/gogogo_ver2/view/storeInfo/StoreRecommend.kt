package com.minseo.gogogo_ver2.view.storeInfo

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayout
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.StoreRecommendBinding
import com.minseo.gogogo_ver2.view_model.GpsUtils
import com.minseo.gogogo_ver2.view_model.LocationViewModel
import com.minseo.gogogo_ver2.view_model.StoreViewModel

class StoreRecommend : AppCompatActivity() {
    private val storeViewModel: StoreViewModel by viewModels()
    private val locationViewModel: LocationViewModel by viewModels()

    private var isGPSEnabled = false
    private lateinit var binding: StoreRecommendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var result = intent?.getStringExtra("result")

        if (savedInstanceState != null) {
            result = savedInstanceState.getString("result")
        }

        if (result?.isNotBlank() != true) {
            finish()
            return
        }

        storeViewModel.result = result
        Log.d("StoreRecommend", result)

        binding = StoreRecommendBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GpsUtils(this).turnGPSOn(object : GpsUtils.OnGpsListener {
            override fun gpsStatus(isGPSEnable: Boolean) {
                this@StoreRecommend.isGPSEnabled = isGPSEnable
            }
        })

        var storeList = StoreList()
        var deliveryList = DeliveryList()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, storeList).commit()

        binding.tabs.addTab(binding.tabs.newTab().setText("매장"))
        binding.tabs.addTab(binding.tabs.newTab().setText("배달"))

        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                Log.d("StoreRecommend", "선택된 탭 : $position")

                var selected: Fragment? = null
                if (position == 0) {
                    selected = storeList
                } else if (position == 1) {
                    selected = deliveryList
                }
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, selected!!).commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("result", storeViewModel.result)
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        invokeLocationAction()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == GPS_REQUEST) {
                isGPSEnabled = true
                invokeLocationAction()
            }
        }
    }

    private fun invokeLocationAction() {
        when {
            !isGPSEnabled -> binding.latLong.text = getString(R.string.enable_gps)

            isPermissionsGranted() -> startLocationUpdate()

            shouldShowRequestPermissionRationale() -> binding.latLong.text =
                getString(R.string.permission_request)

            else -> ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                LOCATION_REQUEST
            )
        }
    }

    private fun startLocationUpdate() {
        locationViewModel.getLocationData().observe(this, Observer {
            binding.latLong.text = getString(R.string.latLong, it.longitude, it.latitude)
            Log.v("longitude", it.longitude.toString())
            Log.v("latitude", it.latitude.toString())
        })
    }

    private fun isPermissionsGranted() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED

    private fun shouldShowRequestPermissionRationale() =
        ActivityCompat.shouldShowRequestPermissionRationale(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) && ActivityCompat.shouldShowRequestPermissionRationale(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_REQUEST -> {
                invokeLocationAction()
            }
        }
    }

    // 뒤로가기 버튼 눌렀을때, 홈화면으로 이동하기
//    override fun onBackPressed() {
//        val intent = Intent(this@StoreRecommend, MainActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//        ContextCompat.startActivity(intent)
//        finish()
//    }
}

const val LOCATION_REQUEST = 100
const val GPS_REQUEST = 101