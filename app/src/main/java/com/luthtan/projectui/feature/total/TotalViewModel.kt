package com.luthtan.projectui.feature.total

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.luthtan.projectui.base.BaseViewModel
import com.luthtan.projectui.base.util.JsonHelper
import com.luthtan.projectui.domain.entity.ItemItem

class TotalViewModel : BaseViewModel() {

    private val _listSelected = MutableLiveData<List<ItemItem>>()
    val listSelected: LiveData<List<ItemItem>> = _listSelected

    private val listSelectedTemp: MutableList<ItemItem> = mutableListOf()

    fun initData(context: Context) {
        val inputModel = JsonHelper.getOutputModel(context)
        listSelectedTemp.addAll(inputModel.item!!)
        _listSelected.value = listSelectedTemp
    }

    fun deleteItem(item: ItemItem) {
        listSelectedTemp.remove(item)
        _listSelected.value = listSelectedTemp
    }
}