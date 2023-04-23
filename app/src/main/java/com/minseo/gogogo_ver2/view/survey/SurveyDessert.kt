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
import com.minseo.gogogo_ver2.databinding.SurveyDessertBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyDessert : Fragment() {
    private lateinit var binding: SurveyDessertBinding
    private val sharedViewModel: SurveyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyDessertBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.surveyDessert = this

        // 이미지뷰 동그랗게
        binding.btGood.background ?: ShapeDrawable(OvalShape())
        binding.btGood.clipToOutline ?: true
        binding.btBad.background ?: ShapeDrawable(OvalShape())
        binding.btBad.clipToOutline ?: true
    }

    fun pickGood() {
        findNavController().navigate(R.id.action_surveyDessert_to_surveyDessertGood)
    }

    fun pickBad() {
        findNavController().navigate(R.id.action_surveyDessert_to_surveyDessertBad)
    }
}