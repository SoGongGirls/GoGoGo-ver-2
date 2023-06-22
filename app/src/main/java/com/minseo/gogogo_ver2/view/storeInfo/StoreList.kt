package com.minseo.gogogo_ver2.view.storeInfo

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.StoreListBinding
import com.minseo.gogogo_ver2.model.StoreItem
import com.minseo.gogogo_ver2.view_model.*
import kotlinx.coroutines.flow.combine
import java.util.*

class StoreList : AppCompatActivity() {

    lateinit var adapter: StoreListAdapter

    private val storeViewModel: StoreViewModel by viewModels()
    private val locationViewModel: LocationViewModel by viewModels()

    private var isGPSEnabled = false
    private lateinit var binding: StoreListBinding

    // 액티비티 생명주기 = launched -> onCreate() -> onStart() -> onResume() -> running -> onPause() -> onStop() -> onDestroy()
    // 가게 정보 또는 현재 위치가 변경될 때마다 RecyclerView 의 데이터를 다시 계산
    private val storeItems by lazy {
        combine(
            listOf(
                storeViewModel.storeData.asFlow(),
                locationViewModel.getLocationData().asFlow()
            )
        ) {
            val items = it[0] as? List<StoreItem>
            val location = it[1] as? LocationModel

            if (items == null || items.isEmpty() || location == null) {
                return@combine items ?: Collections.emptyList<StoreItem>()
            } else {
                items.forEach {
                    it.distance = run {
                        val l1 = Location("l1").apply {
                            latitude = it.latitude
                            longitude = it.longitude
                        }
                        val l2 = Location("l2").apply {
                            latitude = location.latitude
                            longitude = location.longitude
                        }
                        l1.distanceTo(l2).toDouble()
                    }
                }

                return@combine items
            }
        }.asLiveData()
    }

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
        Log.d("StoreList", result)

        binding = StoreListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GpsUtils(this).turnGPSOn(object : GpsUtils.OnGpsListener {
            override fun gpsStatus(isGPSEnable: Boolean) {
                this@StoreList.isGPSEnabled = isGPSEnable
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("result", storeViewModel.result)
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        invokeLocationAction()

        storeViewModel.fetchFirebaseData()

        adapter = StoreListAdapter()
        binding.list.adapter = adapter

        storeItems.observe(this, Observer {
            adapter.submitList(it)
        })
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

//    @Override
//    public void onListItemClick (ListView l, View v, int position, long id) {
//        StoreItem item = (StoreItem) l.getItemAtPosition(position) ;
//
//        String nameStr = item.getStoreName();
//        String gradeStr = item.getStoreGrade();
//    //        double distanceStr = item.getStoreDistance();
//        String logoStr = item.getStoreLogo();
//
//    }
}

const val LOCATION_REQUEST = 100