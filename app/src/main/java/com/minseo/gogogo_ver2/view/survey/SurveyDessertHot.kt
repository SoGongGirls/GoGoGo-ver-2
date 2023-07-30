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
import com.minseo.gogogo_ver2.databinding.SurveyDessertHotBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyDessertHot : Fragment() {
    private lateinit var binding: SurveyDessertHotBinding
    private lateinit var callback: OnBackPressedCallback
    private val sharedViewModel: SurveyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyDessertHotBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.surveyGoodHot = this
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Navigation.findNavController(binding.root).navigate(R.id.action_surveyDessertHot_to_surveyStart1)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

    fun pickSweet() {
        var menu = arrayListOf("마카롱", "츄러스", "도넛", "밀크티", "라떼", "빵")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyDessertHot_to_roulette)
    }

    fun pickSalty() {
        var menu = arrayListOf("스프", "토스트", "핫도그", "샌드위치")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyDessertHot_to_roulette)
    }
}