package com.example.coincap1.ui.rates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coincap.ui.rates.RatesViewModel
import com.example.coincap1.R
import com.example.coincap1.data.rates.DataModel
import com.example.coincap1.data.rates.RatesModel
import com.example.coincap1.databinding.FragmentRatesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RatesFragment : Fragment() {

    private lateinit var viewModel: RatesViewModel
    private var _binding: FragmentRatesBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[RatesViewModel::class.java]
        _binding = FragmentRatesBinding.inflate(inflater, container, false)

        viewModel.rates.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        viewModel.getRates()

        return binding.root
    }

    private fun setupUI(rates: RatesModel) {
        val ratesAdapter = RatesAdapter(rates.data as List<DataModel>?)
        binding.rvRates.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ratesAdapter
        }
        ratesAdapter.onItemClick = {
            val bundle=Bundle().apply{
                putSerializable("RatesItem",it)
            }
            findNavController().navigate(
                R.id.action_nav_rates_to_DRatesFragment,bundle
            )
        }

    }
}