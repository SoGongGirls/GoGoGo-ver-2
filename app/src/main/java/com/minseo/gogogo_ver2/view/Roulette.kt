package com.minseo.gogogo_ver2.view

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.jhdroid.view.RotateListener
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.RouletteBinding
import com.minseo.gogogo_ver2.view_model.SurveyViewModel

class Roulette : Fragment() {
    private lateinit var binding: RouletteBinding
    private lateinit var callback: OnBackPressedCallback
    private val surveyViewModel: SurveyViewModel by activityViewModels()

    private val rouletteData = listOf("닭백숙", "치킨", "닭도리탕", "찜닭", "닭발", "닭갈비")

    @SuppressLint("SetTextI18n")
    private val rouletteListener = object : RotateListener {
        override fun onRotateStart() {
            binding.rotateResultTv.text = "메뉴 추천 결과! : "
        }

        override fun onRotateEnd(result: String) {
            binding.rotateResultTv.text = "메뉴 추천 결과! : $result"
            RouletteDialog(result).show(childFragmentManager, "RouletteDialog")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = RouletteBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        binding.roulette.apply {
            rouletteSize = rouletteData.size
            setRouletteDataList(rouletteData)
        }

        surveyViewModel.picked.observe(viewLifecycleOwner) {
            binding.roulette.rouletteSize = it.size
            binding.roulette.setRouletteDataList(it)
        }

        binding.rotateBtn.setOnClickListener { rotateRoulette() }

        // 내 주변 매장 확인하기
        binding.resultBtn.setOnClickListener {
            val result = binding.rotateResultTv.text.toString().trim().split(":").getOrNull(1)?.trim()
            if (result?.isNotEmpty() != true) return@setOnClickListener

            findNavController().navigate(
                R.id.action_roulette_to_storeList,
                bundleOf("result" to result)
            )
        }

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Navigation.findNavController(binding.root).navigate(R.id.action_roulette_to_surveyStart1)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }

    private fun rotateRoulette() {
        val toDegrees = (2000..10000).random().toFloat()
        binding.roulette.rotateRoulette(toDegrees, 4000, rouletteListener)
    }
}