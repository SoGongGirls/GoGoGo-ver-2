package com.minseo.gogogo_ver2.survey

import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.SurveyDessertDepressedBinding

class SurveyDessertDepressed : AppCompatActivity() {
    var binding = SurveyDessertDepressedBinding.inflate(layoutInflater)
    var count12 = 0 // 찬거-맛 조건
    var count13 = 0 // 찬거-칼로리 조건

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
        count12 += 1
        if (count12 == 2 && count13 == 1) {
            var pick = mutableListOf<String>()
            pick.add("벨기에와플")
            pick.add("아메리칸와플")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else if (count12 == 2) {
            binding.question4.text = "Q. 아이스크림 VS 빙수"

            // 답변 사진
            binding.select12.setImageResource(R.drawable.icecream)
            binding.select13.setImageResource(R.drawable.shavedice)

            // 답변 내용
            binding.select12Tv.text = "아이스크림"
            binding.select13Tv.text = "빙수"
        } else if (count12 == 3) {
            var pick = mutableListOf<String>()
            pick.add("아이스크림")
            pick.add("크로플")
            pick.add("밀크쉐이크")
            pick.add("젤라또")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else {
            binding.question4.text = "Q. 맛 VS 칼로리"
            binding.select12.setImageResource(R.drawable.fiona_person)
            binding.select13.setImageResource(R.drawable.fiona_monster)
            binding.select12Tv.text = "맛"
            binding.select13Tv.text = "칼로리"
        }
    }

    fun selectThirteen(view: View?) {
        count13 += 1
        if (count12 == 1 && count13 == 1) {
            val intent = Intent(applicationContext, SurveyDessertDepressed2::class.java)
            startActivity(intent)
        } else if (count13 == 2) {
            var pick = mutableListOf<String>()
            pick.add("마카롱")
            pick.add("츄러스")
            pick.add("도넛")
            pick.add("쿠키")
            pick.add("호떡")
            pick.add("빵")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else if (count12 == 2 && count13 == 1) {
            var pick = mutableListOf<String>()
            pick.add("딸기빙수")
            pick.add("인절미빙수")
            pick.add("팥빙수")
            pick.add("요거트빙수")
            pick.add("망고빙수")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else {
            binding.question4.text = "Q. 맛 VS 칼로리"

            // 답변 사진
            binding.select12.setImageResource(R.drawable.fiona_person)
            binding.select13.setImageResource(R.drawable.fiona_monster)

            // 답변 내용
            binding.select12Tv.text = "맛"
            binding.select13Tv.text = "칼로리"
        }
    }
}