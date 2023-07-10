package com.minseo.gogogo_ver2.view.survey

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.SurveyMealFishBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyMealFish : Fragment() {
    private var binding: SurveyMealFishBinding? = null
    private val sharedViewModel: SurveyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyMealFishBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.surveyFish = this
    }

    fun pickGrill() {
        var menu = arrayListOf("생선구이", "쭈꾸미", "조개구이", "매운탕", "장어", "대게")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMealFish_to_roulette)
    }

    fun pickSashimi() {
        var menu = arrayListOf("초밥", "게장", "회", "물회", "산낙지")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMealFish_to_roulette)
    }
}