package com.minseo.gogogo_ver2.view.survey

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.SurveyStart1Binding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class SurveyStart1 : Fragment() {
    private lateinit var binding: SurveyStart1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = SurveyStart1Binding.inflate(inflater, container, false)
        binding = fragmentBinding
        initView()
        return fragmentBinding.root
    }

    private fun initView() = with(binding) {
        binding.btStart.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_surveyStart1_to_surveyStart2)
        }
    }
}