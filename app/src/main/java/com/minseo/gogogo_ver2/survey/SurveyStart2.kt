package com.minseo.gogogo_ver2.survey

import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.databinding.SurveyStart2Binding

class SurveyStart2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = SurveyStart2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 이미지뷰 동그랗게
        binding.meal.background = ShapeDrawable(OvalShape())
        binding.meal.clipToOutline = true
        binding.dessert.background = ShapeDrawable(OvalShape())
        binding.dessert.clipToOutline = true
    }

    fun selectMeal(view: View?) {
        val intent = Intent(applicationContext, SurveyMeal::class.java)
        startActivity(intent)
    }

    fun selectDessert(view: View?) {
        val intent = Intent(applicationContext, SurveyDessert::class.java)
        startActivity(intent)
    }
}