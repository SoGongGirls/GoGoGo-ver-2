package com.minseo.gogogo_ver2.survey

import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.Roulette
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
        var pick: Array<String> = Array(4, { "0" })
        pick[0] = "그릭요거트"
        pick[1] = "플레인요거트"
        pick[2] = "딸기요거트"
        pick[3] = "블루베리요거트"

        val intent = Intent(applicationContext, Roulette::class.java)
        intent.putExtra("pick", pick)
        startActivity(intent)
    }

    fun selectThirteen(view: View?) {
        var pick: Array<String> = Array(3, { "0" })
        pick[0] = "망고주스"
        pick[1] = "오렌지주스"
        pick[2] = "수박주스"

        val intent = Intent(applicationContext, Roulette::class.java)
        intent.putExtra("pick", pick)
        startActivity(intent)
    }
}