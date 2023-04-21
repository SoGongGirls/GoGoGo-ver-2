package com.minseo.gogogo_ver2.survey

import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.Roulette
import com.minseo.gogogo_ver2.databinding.SurveyDessertSadBinding

class SurveyDessertSad : AppCompatActivity() {
    var binding = SurveyDessertSadBinding.inflate(layoutInflater)
    var count14 = 0 // 따뜻한거 조건
    var count15 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 이미지뷰 동그랗게
        binding.select14.background = ShapeDrawable(OvalShape())
        binding.select14.clipToOutline = true
        binding.select15.background = ShapeDrawable(OvalShape())
        binding.select15.clipToOutline = true
    }

    fun selectFourteen(view: View?) {
        count14 += 1
        if (count14 == 3 && count15 == 1) {
            var pick: Array<String> = Array(2, { "0" })
            pick[0] = "에그타르트"
            pick[1] = "패션후르츠타르트"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else if (count14 == 3) {
            var pick: Array<String> = Array(4, { "0" })
            pick[0] = "아이스크림"
            pick[1] = "크로플"
            pick[2] = "밀크쉐이크"
            pick[3] = "젤라또"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else if (count14 == 2 && count15 == 1) {
            binding.question5.text = "Q. 타르트 VS 빵"

            // 답변 사진
            binding.select14.setImageResource(R.drawable.tarte)
            binding.select15.setImageResource(R.drawable.macaroon)

            // 답변 내용
            binding.select14Tv.text = "타르트"
            binding.select15Tv.text = "빵"
        }
        else {
            binding.question5.text = "Q. 한입거리 VS 푸짐"

            // 답변 사진
            binding.select14.setImageResource(R.drawable.piglet)
            binding.select15.setImageResource(R.drawable.pooh)

            // 답변 내용
            binding.select14Tv.text = "한입거리"
            binding.select15Tv.text = "푸짐"
        }
    }

    fun selectFifteen(view: View?) {
        count15 += 1
        if (count14 == 1 && count15 == 2) {
            val intent = Intent(applicationContext, SurveyDessertSad2::class.java)
            startActivity(intent)
        }
        else if (count14 == 1 && count15 == 1) {
            var pick: Array<String> = Array(4, { "0" })
            pick[0] = "딸기빙수"
            pick[1] = "인절미빙수"
            pick[2] = "팥빙수"
            pick[3] = "망고빙수"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else if (count14 == 2 && count15 == 2) {
            var pick: Array<String> = Array(6, { "0" })
            pick[0] = "마카롱"
            pick[1] = "츄러스"
            pick[2] = "도넛"
            pick[3] = "쿠키"
            pick[4] = "호떡"
            pick[5] = "빵"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else if (count15 == 2) {
            var pick: Array<String> = Array(5, { "0" })
            pick[0] = "율무차"
            pick[1] = "녹차"
            pick[2] = "홍차"
            pick[3] = "코코아"
            pick[4] = "유자차"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else {
            binding.question5.text = "Q. 맛 VS 칼로리"

            // 답변 사진
            binding.select14.setImageResource(R.drawable.fiona_person)
            binding.select15.setImageResource(R.drawable.fiona_monster)

            // 답변 내용
            binding.select14Tv.text = "맛"
            binding.select15Tv.text = "칼로리"
        }
    }
}