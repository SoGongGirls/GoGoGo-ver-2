package com.minseo.gogogo_ver2.view.storeInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.minseo.gogogo_ver2.databinding.StoreListBinding
import com.minseo.gogogo_ver2.model.StoreItem
import com.minseo.gogogo_ver2.view_model.LocationViewModel
import com.minseo.gogogo_ver2.view_model.StoreViewModel
import com.minseo.gogogo_ver2.view_model.SurveyViewModel
import java.util.*

class StoreList : Fragment() {
    lateinit var binding: StoreListBinding

    lateinit var storeList: ArrayList<StoreItem>
    lateinit var adapter: StoreListAdapter

    private val surveyViewModel: SurveyViewModel by activityViewModels()
    private val storeViewModel: StoreViewModel by activityViewModels()
    private val locationViewModel : LocationViewModel by activityViewModels()

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

        storeList = ArrayList()

        var storeLv = binding.list
        adapter = StoreListAdapter(storeList)
        storeLv.adapter = adapter

//        surveyViewModel.result.observe(viewLifecycleOwner) {
//        }

        storeViewModel.storeData.observe(viewLifecycleOwner) {
            adapter.updateList(it)
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