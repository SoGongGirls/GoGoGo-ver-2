package com.minseo.gogogo_ver2.survey

import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.Roulette
import com.minseo.gogogo_ver2.databinding.SurveyDessertAngryBinding

class SurveyDessertAngry : AppCompatActivity() {
    var binding = SurveyDessertAngryBinding.inflate(layoutInflater)
    var count10 = 0
    var count11 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 이미지뷰 동그랗게
        binding.select10.background = ShapeDrawable(OvalShape())
        binding.select10.clipToOutline = true
        binding.select11.background = ShapeDrawable(OvalShape())
        binding.select11.clipToOutline = true
    }

    fun selectTen(view: View?) {
        count10 += 1
        if (count10 == 2) {
            var pick: Array<String> = Array(4, { "0" })
            pick[0] = "아이스크림"
            pick[1] = "크로플"
            pick[2] = "밀크쉐이크"
            pick[3] = "젤라또"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else if (count10 == 1 && count11 == 1) {
            var pick: Array<String> = Array(2, { "0" })
            pick[0] = "에그타르트"
            pick[1] = "패션후르츠타르트"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else {
            binding.question3.text = "Q. 맛 VS 칼로리"
            binding.select10.setImageResource(R.drawable.fiona_person)
            binding.select11.setImageResource(R.drawable.fiona_monster)
            binding.select10Tv.text = "맛"
            binding.select11Tv.text = "칼로리"
        }
    }

    fun selectEleven(view: View?) {
        count11 += 1
        if (count10 == 1 && count11 == 1) {
            var pick: Array<String> = Array(2, { "0" })
            pick[0] = "녹차"
            pick[1] = "헛개차"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else if (count11 == 2) {
            var pick: Array<String> = Array(5, { "0" })
            pick[0] = "율무차"
            pick[1] = "홍차"
            pick[2] = "꿀차"
            pick[3] = "코코아"
            pick[4] = "유자차"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else {
            binding.question3.text = "Q. 맛 VS 칼로리"

            // 답변 사진
            binding.select10.setImageResource(R.drawable.fiona_person)
            binding.select11.setImageResource(R.drawable.fiona_monster)

            // 답변 내용
            binding.select10Tv.text = "맛"
            binding.select11Tv.text = "칼로리"
        }
    }
}