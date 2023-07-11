package com.minseo.gogogo_ver2.view.storeInfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.minseo.gogogo_ver2.databinding.StoreItemBinding
import com.minseo.gogogo_ver2.model.StoreItem
import java.util.*

class StoreListAdapter(
    private val clickListener: (StoreItem) -> Unit
) : ListAdapter<StoreItem, StoreListAdapter.StoreItemViewHolder>(callback) {

    private lateinit var binding: StoreItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = StoreItemBinding.inflate(inflater, parent, false)
        return StoreItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreItemViewHolder, position: Int) {
        val item = getItem(position)

        with(holder.binding) {
            storeName.text = item.name
            storeGrade.text = item.degree.toString()

            if (item.distance > 1000) {
                storeDistance.text =
                    String.format(Locale.getDefault(), "%.1fkm", item.distance / 1000)
            } else {
                storeDistance.text = String.format(Locale.getDefault(), "%.2fm", item.distance)
            }
        }

//        // 어댑터 안에서 클릭 이벤트 처리
//        binding.root.setOnClickListener {
//            val name = item.name
//            val tel = item.tel
//            val address = item.address
//            Log.e("Adapter", "$name, $tel, $address")
//        }

        binding.root.setOnClickListener {
            clickListener(item)
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