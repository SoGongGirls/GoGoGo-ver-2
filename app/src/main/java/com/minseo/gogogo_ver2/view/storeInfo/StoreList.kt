package com.minseo.gogogo_ver2.view.storeInfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.minseo.gogogo_ver2.DatabaseHelper
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.StoreListBinding
import com.minseo.gogogo_ver2.databinding.SurveyMealBinding
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

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

//        openDB()

        // 리스트뷰 참조 및 Adapter 연결
//        adapter = StoreListAdapter(activity)
//        adapter!!.removeItemAll()

        // 맨 처음 초기화 데이터 보여주기 (select)
//        if (database != null) {
//            val tableName = "store_data"
//            val query = "select name, degree, id, logo, latitude, longitude, menu from $tableName"
//            val cursor = database!!.rawQuery(query, null)
//            Log.v("test", "조회된 데이터 수 : " + cursor.count)
//            for (i in 0 until cursor.count) {
//                cursor.moveToNext()
//                val name = cursor.getString(0)
//                val degree = cursor.getString(1)
//                val id = cursor.getInt(2)
//                val logo = cursor.getString(3)
//                val latitude = cursor.getDouble(4)
//                val longitude = cursor.getDouble(5)
//                val menu = cursor.getString(6)
//                menuList = menu.split(",").toTypedArray()
//                val menuList2 = java.util.ArrayList(Arrays.asList(*menuList))
//
//                adapter!!.addItem(StoreItem(name, degree, id, logo, latitude, longitude))
//            }
//            cursor.close()
//        } else {
//            Log.e("test", "selectData() db없음.")
//        }
//        binding.list.adapter = adapter


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