package com.minseo.gogogo_ver2.survey

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.SurveyStart2Binding

class SurveyStart2 : Fragment() {
    private var binding: SurveyStart2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyStart2Binding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.surveyStart2 = this

        // 이미지뷰 동그랗게
        binding?.btMeal?.background ?: ShapeDrawable(OvalShape())
        binding?.btMeal?.clipToOutline ?: true
        binding?.btDessert?.background ?: ShapeDrawable(OvalShape())
        binding?.btDessert?.clipToOutline ?: true
    }

    fun pickMeal() {
        findNavController().navigate(R.id.action_surveyStart2_to_surveyMeal)
    }

    fun pickDessert() {
        findNavController().navigate(R.id.action_surveyStart2_to_surveyDessert)
    }
}