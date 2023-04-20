package com.minseo.gogogo_ver2.survey

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.minseo.gogogo_ver2.databinding.SurveyStartBinding

class SurveyStart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = SurveyStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(applicationContext, SurveyStart2::class.java)
            startActivity(intent)
        }
    }
}