package com.minseo.gogogo_ver2.view.survey

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.SurveyMealMeatBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyMealMeat : Fragment() {
    private var binding: SurveyMealMeatBinding? = null
    private val sharedViewModel: SurveyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyMealMeatBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.surveyMeat = this

        // 이미지뷰 동그랗게
        binding?.btPork?.background ?: ShapeDrawable(OvalShape())
        binding?.btPork?.clipToOutline ?: true
        binding?.btSteak?.background ?: ShapeDrawable(OvalShape())
        binding?.btSteak?.clipToOutline ?: true
        binding?.btChicken?.background ?: ShapeDrawable(OvalShape())
        binding?.btChicken?.clipToOutline ?: true
        binding?.btElse?.background ?: ShapeDrawable(OvalShape())
        binding?.btElse?.clipToOutline ?: true
    }

    fun pickPork() {
        var menu = arrayListOf("삼겹살", "막창", "탕수육", "족발", "보쌈", "돈까스")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMealMeat_to_roulette)
    }

    fun pickSteak() {
        var menu = arrayListOf("스테이크", "육회", "샤브샤브", "곱창", "소고기구이", "갈비")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMealMeat_to_roulette)
    }

    fun pickChicken() {
        var menu = arrayListOf("닭백숙", "치킨", "닭도리탕", "찜닭", "닭발", "닭갈비")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMealMeat_to_roulette)
    }

    fun pickElse() {
        var menu = arrayListOf("오리탕", "염소고기", "양고기", "오돌뼈", "오리구이", "오리주물럭")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMealMeat_to_roulette)
    }
}