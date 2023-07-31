package com.minseo.gogogo_ver2.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.minseo.gogogo_ver2.model.StoreItem
import kotlin.text.Typography.degree

class StoreViewModel : ViewModel() {
    var _storeData = MutableLiveData<List<StoreItem>>()
    val storeData: LiveData<List<StoreItem>>
        get() = _storeData

    var result: String = ""

    fun fetchFirebaseData() {
        val database = Firebase.database
        val myRef = database.getReference("store")

        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val newStoreData = mutableListOf<StoreItem>()
                for (ds in snapshot.children) {
                    when {
                        result == ds.key -> {
                            val f1 = snapshot.child(result)
                            for (item in f1.children) {
                                val id : String = item.key.toString()
                                val name : String = item.child("name").value as String
                                val address : String = item.child("address").value as String
                                val logo : String = item.child("logo").value as String
                                val latitude : Double = item.child("latitude").value as Double
                                val longitude : Double = item.child("longitude").value as Double
                                val tel : String = item.child("tel").value as String
                                val photo : String = item.child("photo").value as String
                                var degree = 0.0

                                try {
                                    degree = item.child("degree").value as Double
                                }
                                catch (e: java.lang.ClassCastException) {
                                    val degree_1 = item.child("degree").value

                                    if (degree_1 is String)
                                        degree = 0.0
                                    else if (degree_1 is Long)
                                        degree = degree_1.toDouble()
                                }

                                val f1m = StoreItem(id, name, address, degree, logo, latitude, longitude, tel, photo)
                                newStoreData.add(f1m)
                            }
                        }
                    }
                }
                _storeData.value = newStoreData
            }

            override fun onCancelled(error: DatabaseError) {
                // 읽어오기에 실패했을 때
            }
        })
    }
}