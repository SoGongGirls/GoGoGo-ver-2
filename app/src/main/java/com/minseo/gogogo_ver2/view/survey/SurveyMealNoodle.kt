package com.minseo.gogogo_ver2.view.survey

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.SurveyMealNoodleBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyMealNoodle : Fragment() {
    private lateinit var binding: SurveyMealNoodleBinding
    private lateinit var callback: OnBackPressedCallback
    private val sharedViewModel: SurveyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyMealNoodleBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.surveyNoodle = this
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Navigation.findNavController(binding.root).navigate(R.id.action_surveyMealNoodle_to_surveyStart1)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

    fun pickSoup() {
        var menu = arrayListOf("라면", "짬뽕", "우동", "라멘", "물냉면", "국수")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMealNoodle_to_roulette)
    }

    fun pickFried() {
        var menu = arrayListOf("쫄면", "짜장면", "파스타", "비빔냉면")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMealNoodle_to_roulette)
    }
}