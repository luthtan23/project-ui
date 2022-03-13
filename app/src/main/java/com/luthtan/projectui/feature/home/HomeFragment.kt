package com.luthtan.projectui.feature.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.luthtan.projectui.base.BaseFragment
import com.luthtan.projectui.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    override val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val homeHome: HomeAdapter by lazy {
        HomeAdapter(requireContext(), this)
    }

    override fun onInitObservers() {
        viewModel.homeModel.observe(this) {
            homeHome.setData(it)
            binding.tvContentTitle.text = "Content Subtitle (${it.count()} items)"
        }

        viewModel.itemCount.observe(this) {
            binding.tvCountItem.text = "$it Items"
        }
    }

    override fun onInitViews() {
        with(binding.rvContent) {
            adapter = homeHome
            setHasFixedSize(true)
        }

        binding.cvTotalItem.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToTotalFragment())
        }
    }


}