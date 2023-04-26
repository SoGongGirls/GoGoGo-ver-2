package com.minseo.gogogo_ver2.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.minseo.gogogo_ver2.repository.StoreRepository

class StoreViewModelProviderFactory(
    val storeRepository: StoreRepository
) : ViewModelProvider.Factory {
//    override  fun <T: ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(StoreViewModel::class.java)) {
//            return StoreViewModel(storeRepository) as T
//        }
//        throw IllegalArgumentException("unKnown ViewModel class")
//    }
}