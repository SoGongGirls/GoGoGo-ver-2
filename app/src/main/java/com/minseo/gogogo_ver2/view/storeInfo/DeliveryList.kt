package com.minseo.gogogo_ver2.view.storeInfo

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.core.content.ContextCompat.startActivity
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

class DeliveryList : Fragment() {
//    lateinit var binding: DeliveryListBinding
//    var database: SQLiteDatabase? = null
//    var deliveryList: ListView? = null
//    var adapter: DeliveryListAdapter? = null
//    var menuList = arrayOfNulls<String>(5)
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = DeliveryListBinding.inflate(inflater, container, false)

//        openDB()
//
//        // 리스트뷰 참조 및 Adapter 연결
//        adapter = DeliveryListAdapter(activity)
//        adapter!!.removeItemAll()
//
//        //맨처음 초기화 데이터 보여주기(select)
//        if (database != null) {
//            val tableName = "delivery_data"
//            val query = "select name, degree, id, logo, latitude, longitude, menu from $tableName"
//            val cursor = database!!.rawQuery(query, null)
//            Log.v(TAG, "조회된 데이터 수 : " + cursor.count)
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
//                val menuList2 = ArrayList(Arrays.asList(*menuList))
//
//                // 검색결과 변환
//                if (Arrays.asList(*menuList).contains("분식")) {
//                    menuList2.remove("분식")
//                    menuList2.add("김밥")
//                    menuList2.add("떡볶이")
//                    menuList2.add("쫄면")
//                    menuList2.add("만두")
//                    menuList2.add("볶음밥")
//                }
//                if (Arrays.asList(*menuList).contains("중식")) {
//                    menuList2.remove("중식")
//                    menuList2.add("짜장면")
//                    menuList2.add("짬뽕")
//                    menuList2.add("탕수육")
//                    menuList2.add("볶음밥")
//                }
//                if (Arrays.asList(*menuList).contains("꽈배기")) {
//                    menuList2.remove("꽈배기")
//                    menuList2.add("츄러스")
//                }
//                if (Arrays.asList(*menuList).contains("빙수")) {
//                    menuList2.remove("빙수")
//                    menuList2.add("딸기빙수")
//                    menuList2.add("인절미빙수")
//                    menuList2.add("팥빙수")
//                    menuList2.add("요거트빙수")
//                    menuList2.add("망고빙수")
//                }
//                if (Arrays.asList(*menuList).contains("와플")) {
//                    menuList2.remove("와플")
//                    menuList2.add("벨기에와플")
//                    menuList2.add("아메리칸와플")
//                    menuList2.add("크로플")
//                }
//                if (Arrays.asList(*menuList).contains("차")) {
//                    menuList2.remove("차")
//                    menuList2.add("율무차")
//                    menuList2.add("녹차")
//                    menuList2.add("홍차")
//                    menuList2.add("꿀차")
//                    menuList2.add("코코아")
//                    menuList2.add("유자차")
//                    menuList2.add("헛개차")
//                }
//                if (Arrays.asList(*menuList).contains("케익")) {
//                    menuList2.remove("케익")
//                    menuList2.add("치즈케이크")
//                    menuList2.add("초코케이크")
//                    menuList2.add("당근케이크")
//                }
//                if (Arrays.asList(*menuList).contains("타르트")) {
//                    menuList2.remove("타르트")
//                    menuList2.add("에그타르트")
//                    menuList2.add("패션후르츠타르트")
//                }
//                if (Arrays.asList(*menuList).contains("프레즐")) {
//                    menuList2.remove("프레즐")
//                    menuList2.add("츄러스")
//                }
//
//
//                // 룰렛 결과에 해당하는 데이터만 보여주기
////                if (menuList2.contains(Roulette.result3)) {
////                    adapter!!.addItem(DeliveryItem(name, degree, id, logo, latitude, longitude))
////                }
//            }
//            cursor.close()
//        } else {
//            Log.e(TAG, "selectData() db없음.")
//        }
//        binding.list.adapter = adapter
//
//
//        // 리스트 정렬 기능
//        binding.button5.isSelected = true // 기본순 버튼 눌린 상태로 유지
//
//        binding.button3.setOnClickListener {   // 추천순
//            binding.button5.isSelected = false
//            binding.button4.isSelected = false
//            binding.button3.isSelected = true
//            val gradeDesc = Comparator<DeliveryItem> { o1, o2 ->
//                var ret = 0
//                ret =
//                    if (o1.deliveryGrade.compareTo(o2.deliveryGrade) < 0) 1 else if (o1.deliveryGrade.compareTo(
//                            o2.deliveryGrade
//                        ) == 0
//                    ) 0 else -1
//                ret
//            }
//            Collections.sort(DeliveryListAdapter.items, gradeDesc)
//            adapter!!.notifyDataSetChanged()
//        }
//        binding.button4.setOnClickListener {   // 거리순
//            binding.button5.isSelected = false
//            binding.button4.isSelected = true
//            binding.button3.isSelected = false
//            val distanceAsc = Comparator<DeliveryItem> { o1, o2 ->
//                var ret = 0
//                ret =
//                    if (o1.deliveryTime < o2.deliveryTime) -1 else if (o1.deliveryTime == o2.deliveryTime) 0 else 1
//                ret
//            }
//            Collections.sort(DeliveryListAdapter.items, distanceAsc)
//            adapter!!.notifyDataSetChanged()
//        }
//
//
//        // 가게 정보 상세보기
//        deliveryList!!.onItemClickListener =
//            AdapterView.OnItemClickListener { adapterView, view, i, l ->
//                val intent = Intent(activity, DeliveryDetail::class.java)
//                val item = adapter!!.getItem(i) as DeliveryItem
//                val id = item.deliveryId.toString()
//                Log.v(TAG, "id는$id")
//                intent.putExtra("id", id)
//                startActivity(intent)
//            }
//        return binding.root
    }

    //    @Override
    //    public void onListItemClick (ListView l, View v, int position, long id) {
    //        StoreItem item = (StoreItem) l.getItemAtPosition(position) ;
    //
    //        String nameStr = item.getStoreName();
    //        String gradeStr = item.getStoreGrade();
    ////        double distanceStr = item.getStoreDistance();
    //        String logoStr = item.getStoreLogo();
    //
    //    }
    //    public void addItem(Drawable image, String name, String grade, String distance) {
    //        adapter.addItem(image, name, grade, distance);
    //    }
    fun openDB() {
//        Log.v(TAG, "openDB() 실행")
//        val helper = DatabaseHelper(context!!)
//        database = helper.writableDatabase
//        if (database != null) {
//            Log.v(TAG, "DB 열기 성공!")
//        } else {
//            Log.e(TAG, "DB 열기 실패!")
//        }
//    }
}