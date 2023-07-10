package com.minseo.gogogo_ver2.view.survey

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.SurveyDessertBinding
import com.minseo.gogogo_ver2.databinding.SurveyDessertGoodBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyDessertGood : Fragment() {
    private lateinit var binding: SurveyDessertGoodBinding
    private val sharedViewModel: SurveyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyDessertGoodBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.surveyGood = this
    }

    fun pickCold() {
        findNavController().navigate(R.id.action_surveyDessertGood_to_surveyDessertCold)
    }

    fun pickHot() {
        findNavController().navigate(R.id.action_surveyDessertGood_to_surveyDessertHot)
    }
}