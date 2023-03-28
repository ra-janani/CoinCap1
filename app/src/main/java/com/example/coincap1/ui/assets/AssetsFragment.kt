package com.example.coincap1.ui.assets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coincap1.R
import com.example.coincap1.data.assets.DataModel
import com.example.coincap1.data.assets.AssetsModel
import com.example.coincap1.databinding.FragmentAssetsBinding

class AssetsFragment : Fragment() {

    private lateinit var viewModel: AssetsViewModel
    private var _binding: FragmentAssetsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[AssetsViewModel::class.java]
        _binding = FragmentAssetsBinding.inflate(inflater, container, false)

        viewModel.assets.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        viewModel.getAssets()

        return binding.root
    }

    private fun setupUI(assets: AssetsModel) {
        val assetsAdapter=AssetsAdapter(assets.data as List<DataModel?>)
        binding.rvAssets.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = assetsAdapter
        }



        assetsAdapter.onItemClick={
            val bundle=Bundle().apply{
                putSerializable("AssetItem", it)
            }
            findNavController().navigate(
                R.id.action_nav_assets_to_DAssetsFragment, bundle
            )
        }

    }

}