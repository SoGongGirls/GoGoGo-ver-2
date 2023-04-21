package com.minseo.gogogo_ver2.survey

import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.Roulette
import com.minseo.gogogo_ver2.databinding.SurveyMealMeatBinding

class SurveyMealMeat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = SurveyMealMeatBinding.inflate(layoutInflater)
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
        var pick: Array<String> = Array(6, { "0" })
        pick[0] = "삼겹살"
        pick[1] = "막창"
        pick[2] = "탕수육"
        pick[3] = "족발"
        pick[4] = "보쌈"
        pick[5] = "돈까스"

        val intent = Intent(applicationContext, Roulette::class.java)
        intent.putExtra("pick", pick)
        startActivity(intent)
    }

    fun selectTwo(view: View?) {
        var pick: Array<String> = Array(6, { "0" })
        pick[0] = "스테이크"
        pick[1] = "육회"
        pick[2] = "샤브샤브"
        pick[3] = "곱창"
        pick[4] = "소고기구이"
        pick[5] = "갈비"

        val intent = Intent(applicationContext, Roulette::class.java)
        intent.putExtra("pick", pick)
        startActivity(intent)
    }

    fun selectThree(view: View?) {
        var pick: Array<String> = Array(6, { "0" })
        pick[0] = "닭백숙"
        pick[1] = "치킨"
        pick[2] = "닭도리탕"
        pick[3] = "찜닭"
        pick[4] = "닭발"
        pick[5] = "닭갈비"

        val intent = Intent(applicationContext, Roulette::class.java)
        intent.putExtra("pick", pick)
        startActivity(intent)
    }

    fun selectFour(view: View?) {
        var pick: Array<String> = Array(6, { "0" })
        pick[0] = "오리탕"
        pick[1] = "염소고기"
        pick[2] = "양고기"
        pick[3] = "오돌뼈"
        pick[4] = "오리구이"
        pick[5] = "오리주물럭"

        val intent = Intent(applicationContext, Roulette::class.java)
        intent.putExtra("pick", pick)
        startActivity(intent)
    }
}