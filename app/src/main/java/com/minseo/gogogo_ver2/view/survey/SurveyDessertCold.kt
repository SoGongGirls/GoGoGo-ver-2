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
import com.minseo.gogogo_ver2.databinding.SurveyDessertColdBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyDessertCold : Fragment() {
    private lateinit var binding: SurveyDessertColdBinding
    private lateinit var callback: OnBackPressedCallback
    private val sharedViewModel: SurveyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyDessertColdBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.surveyGoodCold = this
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Navigation.findNavController(binding.root).navigate(R.id.action_surveyDessertCold_to_surveyStart1)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

    fun pickTaste() {
        var menu = arrayListOf("스무디", "라떼", "프라푸치노", "밀크티")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyDessertCold_to_roulette)
    }

    fun pickDiet() {
        var menu = arrayListOf("콜드브루", "아이스아메리카노", "샐러드")
        sharedViewModel.setPick(menu)
        findNavController().navigate(R.id.action_surveyDessertCold_to_roulette)
    }
}