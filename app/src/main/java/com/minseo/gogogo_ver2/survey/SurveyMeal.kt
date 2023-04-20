package com.minseo.gogogo_ver2.survey

import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.databinding.SurveyMealBinding
import java.util.ArrayList

class SurveyMeal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = SurveyMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 이미지뷰 동그랗게
        binding.select1.background = ShapeDrawable(OvalShape())
        binding.select1.clipToOutline = true
        binding.select2.background = ShapeDrawable(OvalShape())
        binding.select2.clipToOutline = true
        binding.select3.background = ShapeDrawable(OvalShape())
        binding.select3.clipToOutline = true
        binding.select4.background = ShapeDrawable(OvalShape())
        binding.select4.clipToOutline = true
    }

    fun selectOne(view: View?) {
        val intent = Intent(applicationContext, SurveyMealMeat::class.java)
        startActivity(intent)
    }

    fun selectTwo(view: View?) {
        val intent = Intent(applicationContext, SurveyMealFish::class.java)
        startActivity(intent)
    }

    fun selectThree(view: View?) {
        var pick = mutableListOf<String>()
        pick.add("훠궈")
        pick.add("쌀국수")
        pick.add("타코")
        pick.add("마라탕")

//        val intent = Intent(applicationContext, Roulette::class.java)
//        startActivity(intent)
    }

    fun selectFour(view: View?) {
        val intent = Intent(applicationContext, SurveyMealElse::class.java)
        startActivity(intent)
    }
}