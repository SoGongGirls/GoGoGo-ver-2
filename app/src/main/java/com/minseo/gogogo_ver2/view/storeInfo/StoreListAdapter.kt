package com.minseo.gogogo_ver2.view.storeInfo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.minseo.gogogo_ver2.R

class StoreListAdapter(_items: ArrayList<StoreItem>) : BaseAdapter() {
    var items: ArrayList<StoreItem> = _items
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val context = parent?.context

        if (view == null) {
            val vi = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = vi.inflate(R.layout.store_item, parent, false)
        }

        val storeName = view?.findViewById(R.id.storeName) as TextView
        storeName.text = items[position].name
        val storeGrade = view.findViewById(R.id.storeGrade) as TextView
        storeGrade.text = items[position].degree.toString()

        return view
    }
}