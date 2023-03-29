package com.example.coincap1.ui.exchangedetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coincap.ui.exchangesdetails.ExchangeDetailsViewModel
import com.example.coincap1.R
import com.example.coincap1.data.exchanges.DataModel

import com.example.coincap1.databinding.FragmentDExchangesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DExchangesFragment : Fragment() {

    private var _binding: FragmentDExchangesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ExchangeDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[ExchangeDetailsViewModel::class.java]
        _binding = FragmentDExchangesBinding.inflate(inflater, container, false)

        val exchanges = arguments?.getSerializable("ExchangesItem") as DataModel

        binding.exchangesRank.text = exchanges.rank
        binding.exchangesName.text = exchanges.name
        binding.exchangesTradingPairs.text = exchanges.tradingPairs
        binding.exchangesExchangeUrl.text = exchanges.exchangeUrl
        binding.exchangesId.text = exchanges.id
        binding.exchangesPercentTotalVolume.text = exchanges.percentTotalVolume
        binding.exchangesSocket.text = exchanges.socket.toString()
        binding.exchangesUpdated.text = exchanges.updated.toString()
        binding.exchangesVolumeUsd.text = exchanges.volumeUsd


        return binding.root
    }

}