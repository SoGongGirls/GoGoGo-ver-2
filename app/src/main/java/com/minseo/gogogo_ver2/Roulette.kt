package com.minseo.gogogo_ver2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jhdroid.view.RotateListener
import com.minseo.gogogo_ver2.databinding.ActivityRouletteBinding
import com.minseo.gogogo_ver2.storeInfo.StoreRecommend

class Roulette : AppCompatActivity() {

    private lateinit var binding: ActivityRouletteBinding

    private val rouletteData = listOf("닭백숙", "치킨", "닭도리탕", "찜닭", "닭발", "닭갈비")

    @SuppressLint("SetTextI18n")
    private val rouletteListener = object : RotateListener {
        override fun onRotateStart() {
            binding.rotateResultTv.text = "메뉴 추천 결과! : "
        }

        override fun onRotateEnd(result: String) {
            binding.rotateResultTv.text = "메뉴 추천 결과! : $result"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRouletteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.roulette.apply {
            rouletteSize = 6
            setRouletteDataList(rouletteData)
        }

        binding.rotateBtn.setOnClickListener { rotateRoulette() }

        // 내 주변 매장 확인하기
        binding.resultBtn.setOnClickListener {
            val intent = Intent(applicationContext, StoreRecommend::class.java)
            intent.putExtra("result", binding.rotateResultTv.text)
            startActivity(intent)
        }
    }

    private fun rotateRoulette() {
        val toDegrees = (2000..10000).random().toFloat()
        binding.roulette.rotateRoulette(toDegrees, 4000, rouletteListener)
    }
}