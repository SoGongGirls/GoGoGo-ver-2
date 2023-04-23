package com.minseo.gogogo_ver2.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.minseo.gogogo_ver2.databinding.Fragment3Binding

class Fragment3 : Fragment() {
    lateinit var binding: Fragment3Binding
    //    TextView toolbar_title;
    var viewPager: ViewPager? = null
    var tabLayout: TabLayout? = null

    //    Button go_login;
    //    Button go_message;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(inflater, container, false)

        //임시버튼 두개

//        go_login = (Button) view.findViewById(R.id.go_login);
//        go_message = (Button)view.findViewById(R.id.go_message);

//        go_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), LoginActivity.class));
//            }
//        });

//        go_message.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), ChatFragment.class));
//            }
//        });

//        go_login = (Button) view.findViewById(R.id.go_login);
//        go_message = (Button)view.findViewById(R.id.go_message);

//        go_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), LoginActivity.class));
//            }
//        });
//
//        go_message.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), MessageMain.class));
//            }
//        });

//        toolbar_title.setText("커뮤니티");  // 제목 설정
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("자유 게시판"))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("밥동무 찾기"))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("자취 꿀팁"))
//        binding.viewPager.adapter = PagerAdapter(childFragmentManager)
//        binding.viewPager.isSaveEnabled = false
//        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
//        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                binding.viewPager.currentItem = tab.position
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab) {}
//            override fun onTabReselected(tab: TabLayout.Tab) {}
//        })
        return binding.root
    } // OnCreateView
}