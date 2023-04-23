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
import com.minseo.gogogo_ver2.databinding.SurveyDessertBadBinding
import com.minseo.gogogo_ver2.databinding.SurveyMealBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyDessertBad : Fragment() {
    private lateinit var binding: SurveyDessertBadBinding
    private val sharedViewModel: SurveyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyDessertBadBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.surveyBad = this

        // 이미지뷰 동그랗게
        binding.btSad.background ?: ShapeDrawable(OvalShape())
        binding.btSad.clipToOutline ?: true
        binding.btAngry.background ?: ShapeDrawable(OvalShape())
        binding.btAngry.clipToOutline ?: true
        binding.btDepressed.background ?: ShapeDrawable(OvalShape())
        binding.btDepressed.clipToOutline ?: true
    }

    fun pickSad() {
        findNavController().navigate(R.id.action_surveyDessertBad_to_surveyDessertSad)
    }

    fun pickAngry() {
        findNavController().navigate(R.id.action_surveyDessertBad_to_surveyDessertAngry)
    }

    fun pickDepressed() {
        findNavController().navigate(R.id.action_surveyDessertBad_to_surveyDessertDepressed)
    }
}