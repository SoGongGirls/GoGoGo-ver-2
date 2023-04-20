package com.minseo.gogogo_ver2.survey

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.databinding.SurveyDessertSad2Binding

class SurveyDessertSad2 : AppCompatActivity() {
    var binding = SurveyDessertSad2Binding.inflate(layoutInflater)

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
        var pick = mutableListOf<String>()
        pick.add("치즈케이크")
        pick.add("초코케이크")
        pick.add("당근케이크")
        pick.add("팬케이크")
//        val intent = Intent(applicationContext, Roulette::class.java)
//        startActivity(intent)
    }

    fun selectEight(view: View?) {
        var pick = mutableListOf<String>()
        pick.add("애플파이")
        pick.add("펌킨파이")
        pick.add("떡")
//        val intent = Intent(applicationContext, Roulette::class.java)
//        startActivity(intent)
    }

    fun selectNine(view: View?) {
        var pick = mutableListOf<String>()
        pick.add("벨기에와플")
        pick.add("아메리칸와플")
//        val intent = Intent(applicationContext, Roulette::class.java)
//        startActivity(intent)
    }
}