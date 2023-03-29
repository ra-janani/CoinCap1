package com.example.coincap1.ui.ratesdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.coincap.ui.ratesdetails.RatesDetailsViewModel
import com.example.coincap1.data.rates.DataModel
import com.example.coincap1.databinding.FragmentDRatesBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DRatesFragment : Fragment() {

    private var _binding: FragmentDRatesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RatesDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[RatesDetailsViewModel::class.java]
        _binding = FragmentDRatesBinding.inflate(inflater, container, false)

        val rates = arguments?.getSerializable("RatesItem") as DataModel

        binding.ratesId.text = rates.id
        binding.ratesSymbol.text = rates.symbol
        binding.ratesCurrencySymbol.text = rates.currencySymbol
        binding.ratesRateUsd.text = rates.rateUsd
        binding.ratesType.text = rates.type


        return binding.root
    }

}