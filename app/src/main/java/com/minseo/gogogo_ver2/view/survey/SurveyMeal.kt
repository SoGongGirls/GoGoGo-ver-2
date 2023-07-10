package com.minseo.gogogo_ver2.view.survey

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.RouletteBinding
import com.minseo.gogogo_ver2.databinding.SurveyMealBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyMeal : Fragment() {
    private lateinit var binding: SurveyMealBinding
    private val sharedViewModel: SurveyViewModel by activityViewModels()

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
        binding.surveyMeal = this
    }

    fun pickMeat() {
        findNavController().navigate(R.id.action_surveyMeal_to_surveyMealMeat)
    }

    fun pickFish() {
        findNavController().navigate(R.id.action_surveyMeal_to_surveyMealFish)
    }

    fun pickExotic() {
        var menu = arrayListOf("훠궈", "쌀국수", "타코", "마라탕")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMeal_to_roulette)
    }

    fun pickElse() {
        findNavController().navigate(R.id.action_surveyMeal_to_surveyMealElse)
    }
}