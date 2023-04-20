package com.minseo.gogogo_ver2.survey

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.SurveyMealFishBinding

class SurveyMealFish : AppCompatActivity() {
    var binding = SurveyMealFishBinding.inflate(layoutInflater)
    var count1 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 이미지뷰 동그랗게
        binding.select1.background = ShapeDrawable(OvalShape())
        binding.select1.clipToOutline = true
        binding.select2.background = ShapeDrawable(OvalShape())
        binding.select2.clipToOutline = true
    }

    fun selectOne(view: View?) {
        count1 += 1
        if (count1 == 2) {
            var pick = mutableListOf<String>()
            pick.add("생선구이")
            pick.add("코다리")
            pick.add("생선찜")
            pick.add("매운탕")
            pick.add("장어/복어")
            pick.add("추어탕")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else {
            binding.question.text = "Q. 생선 VS 생선말고"

            // 답변 사진
            binding.select1.setImageResource(R.drawable.eel)
            binding.select2.setImageResource(R.drawable.seafood)

            // 답변 내용
            binding.select1Tv.text = "생선"
            binding.select2Tv.text = "생선말고"
        }
    }

    fun selectTwo(view: View?) {
        count1 += 1
        if (count1 == 2) {
            var pick = mutableListOf<String>()
            pick.add("쭈꾸미/낙지")
            pick.add("해물탕")
            pick.add("대하")
            pick.add("조개구이")
            pick.add("대게")
            pick.add("해물찜")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else {
            var pick = mutableListOf<String>()
            pick.add("초밥")
            pick.add("게장")
            pick.add("회/물회")
            pick.add("연어")
            pick.add("산낙지")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        }
    }
}