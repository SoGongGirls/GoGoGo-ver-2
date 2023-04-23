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
import com.minseo.gogogo_ver2.databinding.SurveyMealElseBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyMealElse : Fragment() {
    private var binding: SurveyMealElseBinding? = null
    private val sharedViewModel: SurveyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyMealElseBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.surveyElse = this

        // 이미지뷰 동그랗게
        binding?.btOne?.background ?: ShapeDrawable(OvalShape())
        binding?.btOne?.clipToOutline ?: true
        binding?.btTwo?.background ?: ShapeDrawable(OvalShape())
        binding?.btTwo?.clipToOutline ?: true
        binding?.btThree?.background ?: ShapeDrawable(OvalShape())
        binding?.btThree?.clipToOutline ?: true
        binding?.btFour?.background ?: ShapeDrawable(OvalShape())
        binding?.btFour?.clipToOutline ?: true
    }

    fun pickOne() {
        var menu = arrayListOf("샌드위치", "햄버거", "피자")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMealElse_to_roulette)
    }

    fun pickTwo() {
        findNavController().navigate(R.id.action_surveyMealElse_to_surveyMealNoodle)
    }

    fun pickThree() {
        findNavController().navigate(R.id.action_surveyMealElse_to_surveyMealRice)
    }

    fun pickFour() {
        var menu = arrayListOf("떡볶이", "만두", "튀김", "순대", "어묵")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMealElse_to_roulette)
    }
}