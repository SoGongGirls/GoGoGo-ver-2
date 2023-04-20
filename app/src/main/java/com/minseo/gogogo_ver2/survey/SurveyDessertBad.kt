package com.minseo.gogogo_ver2.survey

import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.databinding.SurveyDessertBadBinding

class SurveyDessertBad : AppCompatActivity() {
    var binding = SurveyDessertBadBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 이미지뷰 동그랗게
        binding.select7.background = ShapeDrawable(OvalShape())
        binding.select7.clipToOutline = true
        binding.select8.background = ShapeDrawable(OvalShape())
        binding.select8.clipToOutline = true
        binding.select9.background = ShapeDrawable(OvalShape())
        binding.select9.clipToOutline = true
    }

    fun selectSeven(view: View?) {
        val intent = Intent(applicationContext, SurveyDessertSad::class.java)
        startActivity(intent)
    }

    fun selectEight(view: View?) {
        val intent = Intent(applicationContext, SurveyDessertAngry::class.java)
        startActivity(intent)
    }

    fun selectNine(view: View?) {
        val intent = Intent(applicationContext, SurveyDessertDepressed::class.java)
        startActivity(intent)
    }
}