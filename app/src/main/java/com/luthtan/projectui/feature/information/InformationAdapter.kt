package com.luthtan.projectui.feature.information

import com.luthtan.projectui.base.BaseAdapter
import com.luthtan.projectui.databinding.ItemInformationBinding
import com.luthtan.projectui.domain.entity.SubItemItem

class InformationAdapter : BaseAdapter<ItemInformationBinding, SubItemItem>(
    ItemInformationBinding::inflate
) {
    override fun bind(binding: ItemInformationBinding, data: SubItemItem?) {
        if (data != null) {
            binding.tvContentTitle.text = data.name
            binding.tvDescriptionTitle.text = data.description
        }
    }
}