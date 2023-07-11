package com.minseo.gogogo_ver2.view.storeInfo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.databinding.StoreDetailBinding

class StoreDetail : AppCompatActivity() {
    private lateinit var binding: StoreDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = StoreDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storeName.setText(intent.getStringExtra("storeName"))
    }
}