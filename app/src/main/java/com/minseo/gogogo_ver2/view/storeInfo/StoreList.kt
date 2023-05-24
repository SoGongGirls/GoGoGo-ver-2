package com.minseo.gogogo_ver2.view.storeInfo

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.minseo.gogogo_ver2.databinding.StoreListBinding
import com.minseo.gogogo_ver2.model.StoreItem
import com.minseo.gogogo_ver2.view_model.LocationModel
import com.minseo.gogogo_ver2.view_model.LocationViewModel
import com.minseo.gogogo_ver2.view_model.StoreViewModel
import kotlinx.coroutines.flow.combine
import java.util.*

class StoreList : Fragment() {
    lateinit var binding: StoreListBinding

    lateinit var adapter: StoreListAdapter

    private val storeViewModel: StoreViewModel by activityViewModels()
    private val locationViewModel: LocationViewModel by activityViewModels()

    // 가게 정보 또는 현재 위치가 변경될 때마다 RecyclerView 의 데이터를 다시 계산
    private val storeItems by lazy {
        combine(
            listOf(
                storeViewModel.storeData.asFlow(),
                locationViewModel.getLocationData().asFlow()
            )
        ) {
            val items = it[0] as? List<StoreItem>
            val location = it[1] as? LocationModel

            if (items == null || items.isEmpty() || location == null) {
                return@combine items ?: Collections.emptyList<StoreItem>()
            } else {
                items.forEach {
                    it.distance = run {
                        val l1 = Location("l1").apply {
                            latitude = it.latitude
                            longitude = it.longitude
                        }
                        val l2 = Location("l2").apply {
                            latitude = location.latitude
                            longitude = location.longitude
                        }
                        l1.distanceTo(l2).toDouble()
                    }
                }

                return@combine items
            }
        }.asLiveData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        storeViewModel.fetchFirebaseData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = StoreListBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        adapter = StoreListAdapter()
        binding.list.adapter = adapter

//        surveyViewModel.result.observe(viewLifecycleOwner) {
//        }

        storeItems.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

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
}