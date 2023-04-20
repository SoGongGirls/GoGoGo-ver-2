package com.minseo.gogogo_ver2.survey

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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
        var pick = mutableListOf<String>()
        pick.add("삼겹살")
        pick.add("막창")
        pick.add("탕수육")
        pick.add("족발")
        pick.add("보쌈")
        pick.add("돈까스")
//        val intent = Intent(applicationContext, Roulette::class.java)
//        startActivity(intent)
    }

    fun selectTwo(view: View?) {
        var pick = mutableListOf<String>()
        pick.add("스테이크")
        pick.add("육회")
        pick.add("샤브샤브")
        pick.add("곱창")
        pick.add("소고기구이")
        pick.add("갈비")
//        val intent = Intent(applicationContext, Roulette::class.java)
//        startActivity(intent)
    }

    fun selectThree(view: View?) {
        var pick = mutableListOf<String>()
        pick.add("닭백숙")
        pick.add("치킨")
        pick.add("닭도리탕")
        pick.add("찜닭")
        pick.add("닭발")
        pick.add("닭갈비")
//        val intent = Intent(applicationContext, Roulette::class.java)
//        startActivity(intent)
    }

    fun selectFour(view: View?) {
        var pick = mutableListOf<String>()
        pick.add("오리탕")
        pick.add("염소고기")
        pick.add("양고기")
        pick.add("오돌뼈")
        pick.add("오리구이")
        pick.add("오리주물럭")
//        val intent = Intent(applicationContext, Roulette::class.java)
//        startActivity(intent)
    }
}