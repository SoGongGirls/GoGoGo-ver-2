package com.minseo.gogogo_ver2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.minseo.gogogo_ver2.databinding.ActivityMainBinding
import com.minseo.gogogo_ver2.view.survey.SurveyStart

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btStart.setOnClickListener({
            val intent = Intent(this, SurveyStart::class.java)
            startActivity(intent)
        })
    }
}