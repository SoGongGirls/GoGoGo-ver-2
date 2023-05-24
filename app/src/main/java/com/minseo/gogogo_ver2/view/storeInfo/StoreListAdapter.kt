package com.minseo.gogogo_ver2.view.storeInfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.minseo.gogogo_ver2.databinding.StoreItemBinding
import com.minseo.gogogo_ver2.model.StoreItem
import java.util.*

class StoreListAdapter : ListAdapter<StoreItem, StoreListAdapter.StoreItemViewHolder>(callback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = StoreItemBinding.inflate(inflater, parent, false)
        return StoreItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreItemViewHolder, position: Int) {
        val item = getItem(position)

        with(holder.binding) {
            storeName.text = item.name
            storeGrade.text = item.degree.toString()

            if (item.distance > 1000) {
                storeDistance.text =
                    String.format(Locale.getDefault(), "거리: %.1fkm", item.distance / 1000)
            } else {
                storeDistance.text = String.format(Locale.getDefault(), "거리: %.2fm", item.distance)
            }
        }
    }

    class StoreItemViewHolder(val binding: StoreItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        private val callback = object : DiffUtil.ItemCallback<StoreItem>() {
            override fun areItemsTheSame(oldItem: StoreItem, newItem: StoreItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: StoreItem, newItem: StoreItem): Boolean {
                return oldItem.name == newItem.name &&
                        oldItem.degree == newItem.degree &&
                        oldItem.logo == newItem.logo &&
                        oldItem.latitude == newItem.latitude &&
                        oldItem.longitude == newItem.longitude &&
                        oldItem.distance == newItem.distance
            }

            override fun getChangePayload(oldItem: StoreItem, newItem: StoreItem): Any {
                return Any()
            }
        }
    }
}