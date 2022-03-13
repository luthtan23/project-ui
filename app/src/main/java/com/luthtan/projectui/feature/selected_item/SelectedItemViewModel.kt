package com.luthtan.projectui.feature.selected_item

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.luthtan.projectui.base.BaseViewModel
import com.luthtan.projectui.base.util.JsonHelper
import com.luthtan.projectui.domain.entity.ItemItem

class SelectedItemViewModel : BaseViewModel() {

    private val _listSelected = MutableLiveData<List<ItemItem>>()
    val listSelected: LiveData<List<ItemItem>> = _listSelected

    private val _selectedItem = MutableLiveData<MutableList<ItemItem>>()
    val selectedItem: LiveData<MutableList<ItemItem>> = _selectedItem

    private val selectedItemTemp: MutableList<ItemItem> = mutableListOf()
    private val listSelectedTemp: MutableList<ItemItem> = mutableListOf()

    fun initData(context: Context) {
        val inputModel = JsonHelper.getInputModel(context)
        listSelectedTemp.addAll(inputModel.item!!)
        _listSelected.value = listSelectedTemp
        _selectedItem.value = selectedItemTemp
    }

    fun setSelectedItem(item: ItemItem) {
        listSelectedTemp.find { item.name == it.name }?.isSelected = !item.isSelected
        _listSelected.value = listSelectedTemp
        if (item.isSelected) {
            selectedItemTemp.add(item)
        } else {
            selectedItemTemp.remove(item)
        }
        _selectedItem.value = selectedItemTemp
    }
}