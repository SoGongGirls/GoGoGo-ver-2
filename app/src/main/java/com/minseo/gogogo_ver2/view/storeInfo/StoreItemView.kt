package com.minseo.gogogo_ver2.view.storeInfo

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.minseo.gogogo_ver2.R

class StoreItemView : LinearLayout {
    var imageView // 가게 사진
            : ImageView? = null
    var tvName // 가게 이름
            : TextView? = null
    var tvGrade // 가게 등급
            : TextView? = null
    var tvDistance // 거리
            : TextView? = null

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    private fun init(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.store_item, this, true)
        imageView = findViewById(R.id.storeImage)
        tvName = findViewById(R.id.storeName)
        tvGrade = findViewById(R.id.storeGrade)
        tvDistance = findViewById(R.id.storeDistance)

        // 매장 리스트 사진 모서리 조정
//        val drawable = context.getDrawable(R.drawable.round5) as GradientDrawable?
//        imageView.setBackground(drawable)
//        imageView.setClipToOutline(true)
    }

    fun setName(name: String?) {
        tvName!!.text = name
    }

    fun setGrade(grade: String?) {
        tvGrade!!.text = grade
    }

    fun setDistance(distance: Double) {
        val distance2 = String.format("%.2f", distance)
        tvDistance!!.text = "$distance2 km"
    }

    fun setImage(url: String?) {
//        Glide.with(this).load(url).into(imageView!!)
    }
}