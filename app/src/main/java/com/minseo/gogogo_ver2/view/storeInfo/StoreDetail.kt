package com.minseo.gogogo_ver2.view.storeInfo

import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.ContactsContract.PinnedPositions.pin
import android.util.Log
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.StoreDetailBinding
import com.skt.Tmap.TMapMarkerItem
import com.skt.Tmap.TMapPoint
import com.skt.Tmap.TMapView

class StoreDetail : AppCompatActivity() {
    private lateinit var binding: StoreDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = StoreDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storeName.setText(intent.getStringExtra("storeName"))
        binding.storeGrade.setText(intent.getStringExtra("storeGrade"))
        binding.storeTel.setText(intent.getStringExtra("storeTel"))
        binding.storeAddress.setText(intent.getStringExtra("storeAddress"))

        val tMapView = TMapView(this)
        tMapView.setSKTMapApiKey(getString(R.string.tmap_api_key))

        val markerItem = TMapMarkerItem()
        val lat = intent.getDoubleExtra("storeLet", 0.0)
        val long = intent.getDoubleExtra("storeLong", 0.0)
        val tMapPoint = TMapPoint(lat, long)

        val bitmap = BitmapFactory.decodeResource(this.resources, R.drawable.poi_dot)
        markerItem.icon = bitmap
        binding.linearLayoutTmap.addView(tMapView)
        markerItem.setPosition(0.5f, 1.0f)
        markerItem.tMapPoint = tMapPoint
        tMapView.addMarkerItem("markerItem", markerItem)

        Log.d("WHERE", "$lat, $long")
    }
}
