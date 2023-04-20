package com.minseo.gogogo_ver2.survey

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.databinding.SurveyDessertDepressed2Binding

class SurveyDessertDepressed2 : AppCompatActivity() {
    var binding = SurveyDessertDepressed2Binding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 이미지뷰 동그랗게
        binding.select12.background = ShapeDrawable(OvalShape())
        binding.select12.clipToOutline = true
        binding.select13.background = ShapeDrawable(OvalShape())
        binding.select13.clipToOutline = true
    }

    fun selectTwelve(view: View?) {
        var pick = mutableListOf<String>()
        pick.add("그릭요거트")
        pick.add("플레인요거트")
        pick.add("딸기요거트")
        pick.add("블루베리요거트")
//        val intent = Intent(applicationContext, Roulette::class.java)
//        startActivity(intent)
    }

    fun selectThirteen(view: View?) {
        var pick = mutableListOf<String>()
        pick.add("망고주스")
        pick.add("오렌지주스")
        pick.add("수박주스")
//        val intent = Intent(applicationContext, Roulette::class.java)
//        startActivity(intent)
    }
}