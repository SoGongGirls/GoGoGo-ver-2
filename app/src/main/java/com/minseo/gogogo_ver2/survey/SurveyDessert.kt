package com.minseo.gogogo_ver2.survey

import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.databinding.SurveyDessertBinding

class SurveyDessert : AppCompatActivity() {
    var binding = SurveyDessertBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 이미지뷰 동그랗게
        binding.good.background = ShapeDrawable(OvalShape())
        binding.good.clipToOutline = true
        binding.bad.background = ShapeDrawable(OvalShape())
        binding.bad.clipToOutline = true
    }

    fun selectGood(view: View?) {
        val intent = Intent(applicationContext, SurveyDessertGood::class.java)
        startActivity(intent)
    }

    fun selectBad(view: View?) {
        val intent = Intent(applicationContext, SurveyDessertBad::class.java)
        startActivity(intent)
    }
}