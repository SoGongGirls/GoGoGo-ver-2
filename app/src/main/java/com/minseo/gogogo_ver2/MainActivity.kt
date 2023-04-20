package com.minseo.gogogo_ver2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.minseo.gogogo_ver2.databinding.ActivityMainBinding
import com.minseo.gogogo_ver2.fragment.Fragment1
import com.minseo.gogogo_ver2.fragment.Fragment2
import com.minseo.gogogo_ver2.fragment.Fragment3

private const val TAG_FRAGMENT_1 = "fragment1"
private const val TAG_FRAGMENT_2 = "fragment2"
private const val TAG_FRAGMENT_3 = "fragment3"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* fragment 설정 */
        setFragment(TAG_FRAGMENT_1, Fragment1())

        binding.bottom.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_navigation_1 -> setFragment(TAG_FRAGMENT_1, Fragment1())
                R.id.bottom_navigation_2 -> setFragment(TAG_FRAGMENT_2, Fragment2())
                R.id.bottom_navigation_3 -> setFragment(TAG_FRAGMENT_3, Fragment3())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.container, fragment, tag)
        }

        val fragment1 = manager.findFragmentByTag(TAG_FRAGMENT_1)
        val fragment2 = manager.findFragmentByTag(TAG_FRAGMENT_2)
        val fragment3 = manager.findFragmentByTag(TAG_FRAGMENT_3)

        if (fragment1 != null){
            fragTransaction.hide(fragment1)
        }

        if (fragment2 != null){
            fragTransaction.hide(fragment2)
        }

        if (fragment3 != null) {
            fragTransaction.hide(fragment3)
        }

        if (tag == TAG_FRAGMENT_1) {
            if (fragment1 != null){
                fragTransaction.show(fragment1)
            }
        }
        else if (tag == TAG_FRAGMENT_2) {
            if (fragment2 != null) {
                fragTransaction.show(fragment2)
            }
        }

        else if (tag == TAG_FRAGMENT_3){
            if (fragment3 != null){
                fragTransaction.show(fragment3)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}