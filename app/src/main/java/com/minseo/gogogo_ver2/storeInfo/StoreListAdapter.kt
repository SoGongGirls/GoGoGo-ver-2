package com.minseo.gogogo_ver2.storeInfo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class StoreListAdapter(context: Context?) : BaseAdapter() {
    var mContext: Context? = null
    var mLayoutInflater: LayoutInflater? = null

    init {
        mContext = context
        mLayoutInflater = LayoutInflater.from(mContext)
    }

    fun addItem(item: StoreItem) {
        items.add(item)
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun removeItemAll() {
        items.clear()
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        var view: StoreItemView? = null
        view = if (convertView == null) {
            StoreItemView(mContext!!)
        } else {
            convertView as StoreItemView
        }

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        val item = items[position]

        //데이터 값 표시하기
//        view.setName(item.storeName)
//        view.setGrade(item.storeGrade)
//        view.setDistance(item.storeDistance)
//        view.setImage(item.storeLogo)

        return view
    }

    companion object {
        var items = ArrayList<StoreItem>()
    }
}