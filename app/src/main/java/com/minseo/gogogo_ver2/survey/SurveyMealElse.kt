package com.minseo.gogogo_ver2.survey

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.R
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
            var pick = mutableListOf<String>()
            pick.add("라면")
            pick.add("짬뽕")
            pick.add("우동")
            pick.add("라멘")
            pick.add("물냉면")
            pick.add("국수")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else if (count3 == 2) {
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
        } else if (count3 == 3) {
            var pick = mutableListOf<String>()
            pick.add("부대찌개")
            pick.add("김치찌개")
            pick.add("국밥")
            pick.add("육개장/순두부찌개")
            pick.add("감자탕")
            pick.add("된장찌개")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else {
            var pick = mutableListOf<String>()
            pick.add("샌드위치")
            pick.add("햄버거")
            pick.add("피자")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        }
    }

    fun selectTwo(view: View?) {
        count2 += 1
        count3 += 1
        if (count2 == 2 && count3 != 3) {
            var pick = mutableListOf<String>()
            pick.add("쫄면")
            pick.add("짜장면")
            pick.add("파스타")
            pick.add("비빔냉면")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else if (count3 == 2) {
            var pick = mutableListOf<String>()
            pick.add("호박죽")
            pick.add("팥죽")
            pick.add("전복죽")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else if (count3 == 3) {
            var pick = mutableListOf<String>()
            pick.add("컵밥/밥버거")
            pick.add("덮밥")
            pick.add("카레")
            pick.add("김밥")
            pick.add("볶음밥")
            pick.add("백반")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else {
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
        var pick = mutableListOf<String>()
        pick.add("떡볶이")
        pick.add("만두")
        pick.add("튀김")
        pick.add("순대")
        pick.add("어묵")
//        val intent = Intent(applicationContext, Roulette::class.java)
//        startActivity(intent)
    }
}