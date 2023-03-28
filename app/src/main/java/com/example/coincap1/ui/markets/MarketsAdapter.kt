package com.example.coincap1.ui.markets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coincap1.R
import com.example.coincap1.data.markets.DataModel
import com.example.coincap1.databinding.ItemMarketsBinding

class MarketsAdapter(val markets: List<DataModel>?) :
    RecyclerView.Adapter<MarketsAdapter.ViewHolder>() {

    var onItemClick: ((DataModel) -> Unit)? = null

    // ITEM/ROW all the settings/UI of individual items
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemMarketsBinding.bind(view)

        fun handleData(item: DataModel?) {
            binding.textView2.text = item?.baseId
            binding.textView3.text = item?.baseSymbol
            binding.textView4.text = item?.updated.toString()

        }

    }

    // Creates the ITEM/ROW for the UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketsAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_markets, parent, false)

        return ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = markets?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: MarketsAdapter.ViewHolder, position: Int) {
        holder.handleData(markets?.get(position))
        holder.itemView.setOnClickListener {
            markets?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }
}