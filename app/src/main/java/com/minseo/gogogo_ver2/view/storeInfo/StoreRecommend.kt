package com.minseo.gogogo_ver2.view.storeInfo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.minseo.gogogo_ver2.MainActivity
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.StoreRecommendBinding

class StoreRecommend : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = StoreRecommendBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

    // 뒤로가기 버튼 눌렀을때, 홈화면으로 이동하기
    override fun onBackPressed() {
        val intent = Intent(this@StoreRecommend, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }
}