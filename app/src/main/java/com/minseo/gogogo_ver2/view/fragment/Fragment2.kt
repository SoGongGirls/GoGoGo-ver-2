package com.minseo.gogogo_ver2.view.fragment

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.minseo.gogogo_ver2.R
import com.minseo.gogogo_ver2.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    lateinit var binding: Fragment2Binding
//    var adapter: IngredientAdapter? = null
    var TAG = "프래그먼트2"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater, container, false)

//        /* 객체 초기화 */
//        adapter = IngredientAdapter()
//        binding.ingredientList.adapter = adapter // 리스트뷰 어댑터 설정
//
//        // 재료 추가버튼
//        binding.ingredientAdd.setOnClickListener {
//            val intent = Intent(activity, Ingredient_add::class.java)
//            startActivity(intent)
//        }
//        adapter!!.addItem(
//            ContextCompat.getDrawable(activity!!, R.drawable.ic_launcher_background),
//            "아보카도", "2021년 09월 19일"
//        )
//
//        // 새로고침 버튼
//        binding.ingredientRefresh.setOnClickListener {
//            val intent = activity!!.intent
//            activity!!.finish()
//            startActivity(intent)
//        }
//
//        // 보여줄 데이터 가져오기
//        val IQ = IngredientDBQuery(activity)
//        val items = IQ.AllData()
//        Log.v(TAG, "" + IQ.countDB())
//        if (IQ.countDB() > 0) {
//            for (i in 0 until IQ.countDB()) {
//                val item = items[i]
//                val date = item.ingredient_date.replaceFirst("-".toRegex(), "년 ")
//                    .replaceFirst("-".toRegex(), "월 ") + "일"
//                adapter!!.addItem(
//                    ContextCompat.getDrawable(activity!!, R.drawable.ic_launcher_background),
//                    item.ingredient_name, date
//                )
//            }
//        }
//
//        // 레시피 검색
//        binding.recipeSearch.setOnClickListener { //선택한 재료 이름 가져오기
//            var inputING = ""
//            for (i in 0 until adapter!!.count) {
//                val item = adapter!!.getItem(i) as IngredientItem
//                if (item.isCheck) {
//                    //true 일때,
//                    inputING += item.ingredient_name
//                    inputING += " "
//                }
//            }
//            Log.v(TAG, inputING)
//            if (inputING === "") {
//                Toast.makeText(context, "재료를 1개 이상 선택하세요.", Toast.LENGTH_SHORT).show()
//            } else {
//                val intent2 = Intent(activity, Recommend_recipe::class.java)
//                intent2.putExtra("inputING", inputING)
//                startActivity(intent2)
//            }
//        }
        return binding.root
    } // OnCreateView
}