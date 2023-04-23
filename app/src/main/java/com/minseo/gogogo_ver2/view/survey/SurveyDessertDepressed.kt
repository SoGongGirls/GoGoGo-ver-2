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
import com.minseo.gogogo_ver2.databinding.SurveyDessertDepressedBinding
import com.minseo.gogogo_ver2.databinding.SurveyDessertSadBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyDessertDepressed : Fragment() {
    private lateinit var binding: SurveyDessertDepressedBinding
    private val sharedViewModel: SurveyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyDessertDepressedBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.surveyDepressed = this

        // 이미지뷰 동그랗게
        binding.btHot.background ?: ShapeDrawable(OvalShape())
        binding.btHot.clipToOutline ?: true
        binding.btCold.background ?: ShapeDrawable(OvalShape())
        binding.btCold.clipToOutline ?: true
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