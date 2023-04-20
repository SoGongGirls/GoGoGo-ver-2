package com.minseo.gogogo_ver2.survey

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.SurveyDessertGoodBinding

class SurveyDessertGood : AppCompatActivity() {
    var binding = SurveyDessertGoodBinding.inflate(layoutInflater)
    var count5 = 0 // 기분좋아-찬거 조건
    var count6 = 0 // 기분좋아-따뜻한거 조건

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 이미지뷰 동그랗게
        binding.select5.background = ShapeDrawable(OvalShape())
        binding.select5.clipToOutline = true
        binding.select6.background = ShapeDrawable(OvalShape())
        binding.select6.clipToOutline = true
    }

    fun selectFive(view: View?) {
        count5 += 1
        count6 += 1
        if (count5 == 2) {
            binding.question2.text = "Q. 스무디 VS 라떼"

            // 답변 사진
            binding.select5.setImageResource(R.drawable.smoothie)
            binding.select6.setImageResource(R.drawable.latte)

            // 답변 내용
            binding.select5Tv.text = "스무디"
            binding.select6Tv.text = "라떼"
        } else if (count6 == 3) {
            var pick = mutableListOf<String>()
            pick.add("토스트")
            pick.add("샌드위치")
            pick.add("샐러드")
            pick.add("핫도그")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else if (count6 == 2) {
            var pick = mutableListOf<String>()
            pick.add("마카롱")
            pick.add("츄러스")
            pick.add("도넛")
            pick.add("쿠키")
            pick.add("호떡")
            pick.add("빵")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else if (count5 == 3) {
            var pick = mutableListOf<String>()
            pick.add("프라푸치노")
            pick.add("스무디")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else {
            binding.question2.text = "Q. 맛 VS 칼로리"
            binding.select5.setImageResource(R.drawable.fiona_person)
            binding.select6.setImageResource(R.drawable.fiona_monster)
            binding.select5Tv.text = "맛"
            binding.select6Tv.text = "칼로리"
        }
    }

    fun selectSix(view: View?) {
        count6 += 1
        if (count6 == 2 && count5 != 1) {
            binding.question2.text = "Q. 토스트 VS 스프"

            // 답변 사진
            binding.select5.setImageResource(R.drawable.toast)
            binding.select6.setImageResource(R.drawable.soup)

            // 답변 내용
            binding.select5Tv.text = "토스트"
            binding.select6Tv.text = "스프"
        } else if (count5 == 1) {
            var pick = mutableListOf<String>()
            pick.add("콜드브루")
            pick.add("아이스아메리카노")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else if (count6 == 3 && count5 != 2) {
            var pick = mutableListOf<String>()
            pick.add("크림스프")
            pick.add("감자스프")
            pick.add("옥수수스프")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else if (count6 == 3) {
            var pick = mutableListOf<String>()
            pick.add("오곡라떼")
            pick.add("돌체라떼")
            pick.add("스무디")
            pick.add("밀크티")
//            val intent = Intent(applicationContext, Roulette::class.java)
//            startActivity(intent)
        } else {
            binding.question2.text = "Q. 단 VS 짠"

            // 답변 사진
            binding.select5.setImageResource(R.drawable.dounet)
            binding.select6.setImageResource(R.drawable.toast)

            // 답변 내용
            binding.select5Tv.text = "단거"
            binding.select6Tv.text = "짠거"
        }
    }
}