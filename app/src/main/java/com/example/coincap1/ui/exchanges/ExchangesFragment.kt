package com.example.coincap1.ui.exchanges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coincap1.R
import com.example.coincap1.data.exchanges.DataModel
import com.example.coincap1.data.exchanges.ExchangesModel
import com.example.coincap1.databinding.FragmentExchangesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExchangesFragment : Fragment() {

    private lateinit var viewModel: ExchangesViewModel
    private var _binding: FragmentExchangesBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[ExchangesViewModel::class.java]
        _binding = FragmentExchangesBinding.inflate(inflater, container, false)

        viewModel.exchanges.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        viewModel.getExchanges()

        return binding.root
    }

    private fun setupUI(exchanges: ExchangesModel) {
        val exchangesAdapter = ExchangesAdapter(exchanges.data as List<DataModel>?)
        binding.rvExchanges.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = exchangesAdapter
        }
        exchangesAdapter.onItemClick = {
            val bundle=Bundle().apply{
                putSerializable("ExchangesItem",it)
            }
            findNavController().navigate(
                R.id.action_nav_exchanges_to_DExchangesFragment,bundle
            )
        }

    }
}