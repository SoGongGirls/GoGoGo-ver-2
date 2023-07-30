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
import com.minseo.gogogo_ver2.databinding.SurveyMealRiceBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyMealRice : Fragment() {
    private lateinit var binding: SurveyMealRiceBinding
    private lateinit var callback: OnBackPressedCallback
    private val sharedViewModel: SurveyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyMealRiceBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.surveyRice = this
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Navigation.findNavController(binding.root).navigate(R.id.action_surveyMealRice_to_surveyStart1)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

    fun pickSoup() {
        var menu = arrayListOf("부대찌개", "김치찌개", "국밥", "순두부찌개", "감자탕", "된장찌개")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMealRice_to_roulette)
    }

    fun pickFried() {
        var menu = arrayListOf("밥버거", "카레", "김밥", "볶음밥", "죽")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMealRice_to_roulette)
    }
}