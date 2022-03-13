package com.luthtan.projectui.feature.total

import androidx.fragment.app.viewModels
import com.luthtan.projectui.base.BaseFragment
import com.luthtan.projectui.base.util.AlertHelper
import com.luthtan.projectui.databinding.FragmentTotalBinding
import com.luthtan.projectui.domain.entity.ItemItem
import com.luthtan.projectui.feature.selected_item.ItemSelectedListener

class TotalFragment : BaseFragment<FragmentTotalBinding, TotalViewModel>() {

    override val viewModel: TotalViewModel by viewModels()

    override val binding: FragmentTotalBinding by lazy {
        FragmentTotalBinding.inflate(layoutInflater)
    }

    private val totalAdapter: TotalAdapter by lazy {
        TotalAdapter(requireContext())
    }

    override fun onInitViews() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        with(binding.rvTotal) {
            adapter = totalAdapter
            setHasFixedSize(true)
        }

        totalAdapter.setItemSelectedListener(object : ItemSelectedListener {
            override fun onItemClicked(item: ItemItem) {
                AlertHelper.showAlert(requireContext()
                ) { p0, _ ->
                    viewModel.deleteItem(item)
                    p0.dismiss()
                }
            }
        })

        binding.cvContinue.setOnClickListener {
            showToast("Where will this go?")
        }
    }

    override fun onInitObservers() {
        viewModel.initData(requireContext())

        viewModel.listSelected.observe(this) {
            totalAdapter.setData(it)
        }
    }
}