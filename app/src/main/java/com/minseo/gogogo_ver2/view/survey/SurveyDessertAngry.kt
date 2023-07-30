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
import com.minseo.gogogo_ver2.databinding.SurveyDessertAngryBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyDessertAngry : Fragment() {
    private lateinit var binding: SurveyDessertAngryBinding
    private lateinit var callback: OnBackPressedCallback
    private val sharedViewModel: SurveyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyDessertAngryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.surveyAngry = this
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Navigation.findNavController(binding.root).navigate(R.id.action_surveyDessertAngry_to_surveyStart1)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

    fun pickHot() {
        var menu = arrayListOf("빵", "도넛", "마카롱", "케이크", "와플")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMeal_to_roulette)
    }

    fun pickCold() {
        var menu = arrayListOf("아이스크림", "빙수", "밀크쉐이크", "젤라또")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyMeal_to_roulette)
    }
}