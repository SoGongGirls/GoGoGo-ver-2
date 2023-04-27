package com.minseo.gogogo_ver2.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.minseo.gogogo_ver2.model.StoreItem

class StoreRepository(
    val databaseReference: DatabaseReference,
) {
    fun getFirebaseData(
        mutableLiveData: MutableLiveData<MutableList<StoreItem>>
    ) {
        databaseReference.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var storeList = mutableListOf<StoreItem>()

                for (snapshot in snapshot.children) {
                    val store = snapshot.getValue(StoreItem::class.java)
                    if (store != null) {
                        storeList.add(store)
                    }
                }
                mutableLiveData.value = storeList
            }

            override fun onCancelled(error: DatabaseError) {
                // 읽어오기에 실패했을 때
            }
        })
    }
}