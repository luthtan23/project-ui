package com.luthtan.projectui.feature.selected_item

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.luthtan.projectui.base.BaseFragment
import com.luthtan.projectui.databinding.FragmentSelectedItemBinding
import com.luthtan.projectui.domain.entity.ItemItem

class SelectedItemFragment : BaseFragment<FragmentSelectedItemBinding, SelectedItemViewModel>() {

    override val viewModel: SelectedItemViewModel by viewModels()

    override val binding: FragmentSelectedItemBinding by lazy {
        FragmentSelectedItemBinding.inflate(layoutInflater)
    }

    private val selectedItemAdapter: SelectedItemAdapter by lazy {
        SelectedItemAdapter(requireContext())
    }

    private val args: SelectedItemFragmentArgs by navArgs()

    override fun onInitViews() {
        binding.tvTitleItem.text = args.title
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        with(binding.rvSelected) {
            adapter = selectedItemAdapter
            setHasFixedSize(true)
        }

        selectedItemAdapter.setItemSelectedListener(object : ItemSelectedListener {
            override fun onItemClicked(item: ItemItem) {
                viewModel.setSelectedItem(item)
            }
        })

        binding.cvAddedItem.setOnClickListener {
            showToast("Where will this go?")
        }
    }

    override fun onInitObservers() {
        viewModel.initData(requireContext())
        viewModel.listSelected.observe(this) {
            selectedItemAdapter.setData(it)
        }
        viewModel.selectedItem.observe(this) {
            binding.tvCountItem.text = "Add ${it.size} item/s"
            var priceTotal = 0
            for (i in it.indices) {
                priceTotal += it[i].price?.toInt()!!
            }
            binding.tvPriceItem.text = "IDR $priceTotal"
        }
    }
}