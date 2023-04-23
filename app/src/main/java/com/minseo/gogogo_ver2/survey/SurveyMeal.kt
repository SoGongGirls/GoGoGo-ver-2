package com.minseo.gogogo_ver2.survey

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.SurveyMealBinding

class SurveyMeal : Fragment() {
    private var binding: SurveyMealBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyMealBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.surveyMeal = this

        // 이미지뷰 동그랗게
        binding?.btMeat?.background ?: ShapeDrawable(OvalShape())
        binding?.btMeat?.clipToOutline ?: true
        binding?.btFish?.background ?: ShapeDrawable(OvalShape())
        binding?.btFish?.clipToOutline ?: true
        binding?.btExotic?.background ?: ShapeDrawable(OvalShape())
        binding?.btExotic?.clipToOutline ?: true
        binding?.btElse?.background ?: ShapeDrawable(OvalShape())
        binding?.btElse?.clipToOutline ?: true
    }

    fun pickMeat() {
        findNavController().navigate(R.id.action_surveyStart2_to_surveyMeal)
    }
}