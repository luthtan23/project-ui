package com.luthtan.projectui.feature.selected_item

import com.luthtan.projectui.domain.entity.ItemItem

interface ItemSelectedListener {
    fun onItemClicked(item: ItemItem)
}