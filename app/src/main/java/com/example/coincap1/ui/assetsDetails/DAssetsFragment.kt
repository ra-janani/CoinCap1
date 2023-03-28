package com.example.coincap1.ui.assetsDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coincap1.R
import com.example.coincap1.data.assets.DataModel
import com.example.coincap1.databinding.FragmentDAssetsBinding
import com.example.coincap1.ui.assetsDetails.DAssetsViewModel

class DAssetsFragment : Fragment() {

    private var _binding: FragmentDAssetsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DAssetsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[DAssetsViewModel::class.java]
        _binding = FragmentDAssetsBinding.inflate(inflater, container, false)

        val assets = arguments?.getSerializable("AssetItem") as DataModel

        binding.assetRank.text = assets.rank
        binding.assetName.text = assets.name
        binding.assetSymbol.text = assets.symbol
        binding.assetChangePercent24Hr.text = assets.changePercent24Hr
        binding.assetMarketCapUsd.text = assets.marketCapUsd
        binding.assetMaxSupply.text = assets.maxSupply
        binding.assetPriceUsd.text = assets.priceUsd
        binding.assetSupply.text = assets.supply
        binding.assetVolumeUsd24Hr.text = assets.volumeUsd24Hr
        binding.assetVwap24Hr.text = assets.vwap24Hr
        binding.assetId.text = assets.id


        return binding.root
    }

}