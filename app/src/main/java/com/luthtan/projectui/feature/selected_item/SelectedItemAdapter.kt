package com.luthtan.projectui.feature.selected_item

import android.content.Context
import android.view.View
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.luthtan.projectui.R
import com.luthtan.projectui.base.BaseAdapter
import com.luthtan.projectui.databinding.ItemSelectedBinding
import com.luthtan.projectui.domain.entity.ItemItem

class SelectedItemAdapter(private val context: Context) : BaseAdapter<ItemSelectedBinding, ItemItem>(
    ItemSelectedBinding::inflate
) {
    private var itemSelectedListener: ItemSelectedListener? = null

    fun setItemSelectedListener(itemSelectedListener: ItemSelectedListener) {
        this.itemSelectedListener = itemSelectedListener
    }

    override fun bind(binding: ItemSelectedBinding, data: ItemItem?) {
        if (data != null) {
            binding.cbFrame.setOnClickListener {
                binding.cbItem.isChecked = !data.isSelected
                itemSelectedListener?.onItemClicked(data)
            }
            binding.tvTitleItem.text = data.name
            Glide.with(context)
                .load(data.iconUrl)
                .placeholder(R.drawable.rectangle)
                .error(R.drawable.rectangle)
                .into(binding.imageSelected)
            binding.btnInfo.visibility = if (data.name == "item 1") View.VISIBLE else View.GONE
            binding.tvPriceItem.text = "${data.currency} ${data.price}"
            binding.btnInfo.setOnClickListener {
                it.findNavController().navigate(SelectedItemFragmentDirections.actionSelectedItemFragmentToInformationFragment(data))
            }
        }
    }
}