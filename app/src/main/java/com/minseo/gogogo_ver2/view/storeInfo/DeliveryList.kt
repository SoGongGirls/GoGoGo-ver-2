package com.minseo.gogogo_ver2.view.storeInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.minseo.gogogo_ver2.databinding.DeliveryListBinding
import com.minseo.gogogo_ver2.model.StoreItem

class DeliveryList : Fragment() {
    lateinit var binding: DeliveryListBinding

    val database = Firebase.database
    val myRef = database.getReference("store")

    lateinit var storeList: java.util.ArrayList<StoreItem>
    lateinit var adapter: StoreListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = DeliveryListBinding.inflate(inflater, container, false)
        binding = fragmentBinding


        return fragmentBinding.root
    }

    // 원하는 위치에서 위치까지 거리를 계산해주는 함수
//    fun getDistance(lat1: Double, lng1: Double, lat2: Double, lng2: Double) : Float{
//        val myLoc = Location(LocationManager.NETWORK_PROVIDER)
//        val targetLoc = Location(LocationManager.NETWORK_PROVIDER)
//        myLoc.latitude= lat1
//        myLoc.longitude = lng1
//
//        targetLoc.latitude= lat2
//        targetLoc.longitude = lng2
//
//        return myLoc.distanceTo(targetLoc)
//    }

//    @Override
//    public void onListItemClick (ListView l, View v, int position, long id) {
//        StoreItem item = (StoreItem) l.getItemAtPosition(position) ;
//
//        String nameStr = item.getStoreName();
//        String gradeStr = item.getStoreGrade();
//    //        double distanceStr = item.getStoreDistance();
//        String logoStr = item.getStoreLogo();
//
//    }
//
//    public void addItem(Drawable image, String name, String grade, String distance) {
//        adapter.addItem(image, name, grade, distance);
//    }

}