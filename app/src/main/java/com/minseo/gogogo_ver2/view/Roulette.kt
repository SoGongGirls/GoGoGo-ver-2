package com.minseo.gogogo_ver2.view

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.jhdroid.view.RotateListener
import com.minseo.gogogo_ver2.databinding.RouletteBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class Roulette : Fragment() {
    private lateinit var binding: RouletteBinding
    private val sharedViewModel: SurveyViewModel by activityViewModels()

//    private val rouletteData = sharedViewModel.pickedOption
    private val rouletteData = listOf("닭백숙", "치킨", "닭도리탕", "찜닭", "닭발", "닭갈비")

    @SuppressLint("SetTextI18n")
    private val rouletteListener = object : RotateListener {
        override fun onRotateStart() {
            binding.rotateResultTv.text = "메뉴 추천 결과! : "
        }

        override fun onRotateEnd(result: String) {
            binding.rotateResultTv.text = "메뉴 추천 결과! : $result"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = RouletteBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        binding.roulette.apply {
            rouletteSize = 6
            setRouletteDataList(rouletteData)
        }

        binding.rotateBtn.setOnClickListener { rotateRoulette() }

        // 내 주변 매장 확인하기
//        binding.resultBtn.setOnClickListener {
//            val intent = Intent(applicationContext, StoreRecommend::class.java)
//            intent.putExtra("result", binding.rotateResultTv.text)
//            startActivity(intent)
//        }

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.roulette = this   // error!

    }

    private fun rotateRoulette() {
        val toDegrees = (2000..10000).random().toFloat()
        binding.roulette.rotateRoulette(toDegrees, 4000, rouletteListener)
    }
}