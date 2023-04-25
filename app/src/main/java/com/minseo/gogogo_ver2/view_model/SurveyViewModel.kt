package com.minseo.gogogo_ver2.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SurveyViewModel : ViewModel() {
    private val _picked = MutableLiveData<ArrayList<String>>()   // 설문을 통해 골라진 메뉴 후보
    var picked : LiveData<ArrayList<String>> = _picked

    private val _result = MutableLiveData<String>()
    var result: LiveData<String> = _result

    var pickedOption: List<String> = picked.value ?: emptyList()

    fun setPick(desiredFood: ArrayList<String>) {
        _picked.value = desiredFood
    }

    fun setRoulette(pickedFood: String) {
        _result.value = pickedFood
    }
}