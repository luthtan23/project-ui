package com.luthtan.projectui.feature.information

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.luthtan.projectui.base.BaseFragment
import com.luthtan.projectui.databinding.FragmentInformationBinding

class InformationFragment : BaseFragment<FragmentInformationBinding, InformationViewModel>() {

    override val viewModel: InformationViewModel by viewModels()

    override val binding: FragmentInformationBinding by lazy {
        FragmentInformationBinding.inflate(layoutInflater)
    }

    private val informationAdapter: InformationAdapter by lazy {
        InformationAdapter()
    }

    private val args: InformationFragmentArgs by navArgs()

    override fun onInitViews() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        binding.tvTitleItem.text = args.item.name
        binding.tvPriceItem.text = "${args.item.currency} ${args.item.price}"
        binding.tvDescriptionTitle.text = args.item.helpInfo?.description

        with(binding.rvInformation) {
            adapter = informationAdapter
            setHasFixedSize(true)
        }

        informationAdapter.setData(args.item.helpInfo?.subItem!!)
    }

    override fun onInitObservers() {

    }
}