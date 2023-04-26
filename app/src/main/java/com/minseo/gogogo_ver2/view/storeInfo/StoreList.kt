package com.minseo.gogogo_ver2.view.storeInfo

import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.minseo.gogogo_ver2.databinding.StoreListBinding
import java.util.*

class StoreList : Fragment() {
    lateinit var binding: StoreListBinding

    val database = Firebase.database
    val myRef = database.getReference("store")

    lateinit var storeList: ArrayList<StoreItem>
    lateinit var adapter: StoreListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = StoreListBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        storeList = ArrayList()

        var storeLv = binding.list
        adapter = StoreListAdapter(storeList)
        storeLv.adapter = adapter

        myRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children) {
                    when {
                        "삼겹살".equals(ds.key) -> {
                            val f1 = snapshot.child("삼겹살")
                            for (item in f1.children) {
                                val id : String = item.key.toString()
                                val name : String = item.child("name").value as String
                                val degree : Double = item.child("degree").value as Double
                                val logo : String = item.child("logo").value as String
                                val latitude : Double = item.child("latitude").value as Double
                                val longitude : Double = item.child("longitude").value as Double

                                val f1m = StoreItem(id, name, degree, logo, latitude, longitude)
                                storeList.add(f1m)
                            }
                        }
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // 읽어오기에 실패했을 때
            }
        })

//        // 리스트 정렬 기능
//        binding.button5.isSelected = true // 기본순 버튼 눌린 상태로 유지
//
//        binding.button3.setOnClickListener {   // 추천순
//            binding.button5.isSelected = false
//            binding.button4.isSelected = false
//            binding.button3.isSelected = true
//            val gradeDesc = Comparator<StoreItem> { o1, o2 ->
//                var ret = 0
//                ret =
//                    if (o1.storeGrade.compareTo(o2.storeGrade) < 0) 1 else if (o1.storeGrade.compareTo(
//                            o2.storeGrade
//                        ) == 0
//                    ) 0 else -1
//                ret
//            }
//            Collections.sort(StoreListAdapter.items, gradeDesc)
//            adapter!!.notifyDataSetChanged()
//        }
//        binding.button4.setOnClickListener {   // 거리순
//            binding.button5.isSelected = false
//            binding.button4.isSelected = true
//            binding.button3.isSelected = false
//            val distanceAsc = Comparator<StoreItem> { o1, o2 ->
//                var ret = 0
//                ret =
//                    if (o1.storeDistance < o2.storeDistance) -1 else if (o1.storeDistance == o2.storeDistance) 0 else 1
//                ret
//            }
//            Collections.sort(StoreListAdapter.items, distanceAsc)
//            adapter!!.notifyDataSetChanged()
//        }
//
//
//        // 가게 정보 상세보기
//        storeList!!.onItemClickListener =
//            AdapterView.OnItemClickListener { adapterView, view, i, l ->
//                val intent = Intent(activity, StoreDetail::class.java)
//                val item = adapter!!.getItem(i) as StoreItem
//                val id = item.storeId.toString()
//                Log.v(TAG, "id는$id")
//                intent.putExtra("id", id)
//                startActivity(intent)
//            }
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