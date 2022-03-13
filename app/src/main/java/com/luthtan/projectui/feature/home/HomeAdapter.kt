package com.luthtan.projectui.feature.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.flexbox.FlexboxLayoutManager
import com.luthtan.projectui.base.BaseAdapter
import com.luthtan.projectui.databinding.ItemContentBinding
import com.luthtan.projectui.domain.entity.HomeModel

class HomeAdapter(private val context: Context, fragment: Fragment) :
    BaseAdapter<ItemContentBinding, HomeModel>(
        ItemContentBinding::inflate
    ) {

    override fun bind(binding: ItemContentBinding, data: HomeModel?) {
        if (data != null) {
            val tagsAdapter = TagAdapter()
            tagsAdapter.setData(data.tags)
            binding.tvContentTitle.text = data.title
            with(binding.rvTag) {
                layoutManager = FlexboxLayoutManager(context)
                adapter = tagsAdapter
                setHasFixedSize(true)
            }
            binding.imageItem.setImageResource(data.images)
            binding.viewClick.setOnClickListener {
                it.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSelectedItemFragment(data.title))
            }
        }
    }
}