package com.minseo.gogogo_ver2.survey

import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.Roulette
import com.minseo.gogogo_ver2.databinding.SurveyMealElseBinding

class SurveyMealElse : AppCompatActivity() {
    var binding = SurveyMealElseBinding.inflate(layoutInflater)
    var count2 = 0
    var count3 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        count2 += 1
        count3 += 1
        if (count2 == 2 && count3 != 3) {
            var pick: Array<String> = Array(7, { "0" })
            pick[0] = "아이스크림"
            pick[1] = "라면"
            pick[2] = "짬뽕"
            pick[3] = "우동"
            pick[4] = "라멘"
            pick[5] = "물냉면"
            pick[6] = "국수"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else if (count3 == 2) {
            binding.question.text = "Q. 뜨끈한국물과 VS 국물말고"

            // 답변 사진
            binding.select1.setImageResource(R.drawable.jjigae)
            binding.select2.setImageResource(R.drawable.rice2)
            binding.select3.setImageResource(R.drawable.white)
            binding.select4.setImageResource(R.drawable.white)

            // 답변 내용
            binding.select1Tv.text = "뜨끈한국물과"
            binding.select2Tv.text = "국물말고"
            binding.select3Tv.text = ""
            binding.select4Tv.text = ""
        }
        else if (count3 == 3) {
            var pick: Array<String> = Array(6, { "0" })
            pick[0] = "부대찌개"
            pick[1] = "김치찌개"
            pick[2] = "국밥"
            pick[3] = "육개장/순두부찌개"
            pick[4] = "감자탕"
            pick[5] = "된장찌개"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else {
            var pick: Array<String> = Array(3, { "0" })
            pick[0] = "샌드위치"
            pick[1] = "햄버거"
            pick[2] = "피자"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
    }

    fun selectTwo(view: View?) {
        count2 += 1
        count3 += 1
        if (count2 == 2 && count3 != 3) {
            var pick: Array<String> = Array(4, { "0" })
            pick[0] = "쫄면"
            pick[1] = "짜장면"
            pick[2] = "파스타"
            pick[3] = "비빔냉면"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else if (count3 == 2) {
            var pick: Array<String> = Array(3, { "0" })
            pick[0] = "호박죽"
            pick[1] = "팥죽"
            pick[2] = "전복죽"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else if (count3 == 3) {
            var pick: Array<String> = Array(6, { "0" })
            pick[0] = "컵밥/밥버거"
            pick[1] = "덮밥"
            pick[2] = "카레"
            pick[3] = "김밥"
            pick[4] = "볶음밥"
            pick[5] = "백반"

            val intent = Intent(applicationContext, Roulette::class.java)
            intent.putExtra("pick", pick)
            startActivity(intent)
        }
        else {
            binding.question.text = "Q. 국물 VS 안국물"

            // 답변 사진
            binding.select1.setImageResource(R.drawable.ramen)
            binding.select2.setImageResource(R.drawable.jajangmyeon)
            binding.select3.setImageResource(R.drawable.white)
            binding.select4.setImageResource(R.drawable.white)

            // 답변 내용
            binding.select1Tv.text = "국물"
            binding.select2Tv.text = "안국물"
            binding.select3Tv.text = ""
            binding.select4Tv.text = ""
        }
    }

    fun selectThree(view: View?) {
        count3 += 1
        binding.question.text = "Q. 밥 VS 죽"

        // 답변 사진
        binding.select1.setImageResource(R.drawable.rice1)
        binding.select2.setImageResource(R.drawable.juk)
        binding.select3.setImageResource(R.drawable.white)
        binding.select4.setImageResource(R.drawable.white)

        // 답변 내용
        binding.select1Tv.text = "밥"
        binding.select2Tv.text = "죽"
        binding.select3Tv.text = ""
        binding.select4Tv.text = ""
    }

    fun selectFour(view: View?) {
        var pick: Array<String> = Array(5, { "0" })
        pick[0] = "떡볶이"
        pick[1] = "만두"
        pick[2] = "튀김"
        pick[3] = "순대"
        pick[4] = "어묵"

        val intent = Intent(applicationContext, Roulette::class.java)
        intent.putExtra("pick", pick)
        startActivity(intent)
    }
}