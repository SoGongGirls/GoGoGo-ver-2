package com.minseo.gogogo_ver2.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.minseo.gogogo_ver2.model.Store
import com.minseo.gogogo_ver2.repository.StoreRepository

class StoreViewModel (val storeRepository: StoreRepository) : ViewModel() {
    var _storeData = MutableLiveData<MutableList<Store>>()

    val storeData get() = getData()

    private fun getData(): MutableLiveData<MutableList<Store>> {
        storeRepository.getFirebaseData(storeData)
        return storeData
    }
}