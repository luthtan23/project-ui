package com.luthtan.projectui.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.luthtan.projectui.R
import com.luthtan.projectui.base.BaseViewModel
import com.luthtan.projectui.domain.entity.HomeModel

class HomeViewModel : BaseViewModel() {

    private val _homeModel = MutableLiveData<List<HomeModel>>()
    val homeModel: LiveData<List<HomeModel>> = _homeModel

    private val _itemCount = MutableLiveData<Int>()
    val itemCount: LiveData<Int> = _itemCount

    private var itemCountTemp = 0

    init {
        _showToast.value = "Test"
        _homeModel.value = listOf(
            HomeModel(
                "Item Title 1",
                mutableListOf(),
                R.drawable.ellipse
            ),
            HomeModel(
                "Item Title 2",
                mutableListOf("Selected Item 1"),
                R.drawable.ellipse
            ),
            HomeModel(
                "Item Title 3",
                mutableListOf("Selected Item 1", " Short", "Long Test"),
                R.drawable.ellipse
            ),
            HomeModel(
                "Item Title 4",
                mutableListOf("Selected Item 1", "Selected Item 2", "Selected Item 3", " Short", "Selected Item 5"),
                R.drawable.ellipse
            )
        )
        for (i in homeModel.value?.indices!!) {
            itemCountTemp += homeModel.value!![i].tags.size
        }

        _itemCount.value = itemCountTemp
    }
}