package com.luthtan.projectui.feature.home

import com.luthtan.projectui.base.BaseAdapter
import com.luthtan.projectui.databinding.ItemTagBinding

class TagAdapter : BaseAdapter<ItemTagBinding, String>(
    ItemTagBinding::inflate
) {

    override fun bind(binding: ItemTagBinding, data: String?) {
        if (data != null) {
            binding.tvTag.text = data
        }
    }

}