package com.minseo.gogogo_ver2.fragment

import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.minseo.gogogo_ver2.databinding.Fragment1Binding
import com.minseo.gogogo_ver2.survey.SurveyStart

class Fragment1 : Fragment() {
    lateinit var binding: Fragment1Binding
    //    TextView toolbar_title;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)

        /* 객체 초기화 */
//        toolbar_title = (TextView) view.findViewById(R.id.toolbar_title);
        binding.cookYes.background = ShapeDrawable(OvalShape())
        binding.cookYes.clipToOutline = true
//        toolbar_title.setText("메뉴 추천");  // 제목 설정
        binding.cookYes.setOnClickListener {
//            val intent = Intent(activity, Cook_Yes::class.java)
//            startActivity(intent)
        }

        /* 요리안해 화면 전환 */
        binding.cookNo.background = ShapeDrawable(OvalShape())
        binding.cookNo.clipToOutline = true
        binding.cookNo.setOnClickListener {
            val intent = Intent(activity, SurveyStart::class.java)
            startActivity(intent)
        }

        return binding.root
    } // OnCreateView
}