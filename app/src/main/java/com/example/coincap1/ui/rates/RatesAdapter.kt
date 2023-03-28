package com.example.coincap1.ui.rates


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coincap1.R
import com.example.coincap1.data.rates.DataModel
import com.example.coincap1.databinding.ItemRatesBinding

class RatesAdapter(val rates: List<DataModel>?) :
    RecyclerView.Adapter<RatesAdapter.ViewHolder>() {

    var onItemClick: ((DataModel) -> Unit)? = null

    // ITEM/ROW all the settings/UI of individual items
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemRatesBinding.bind(view)

        fun handleData(item: DataModel?) {
            binding.textView2.text = item?.id
            binding.textView3.text = item?.symbol

        }

    }

    // Creates the ITEM/ROW for the UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatesAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rates, parent, false)

        return  ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = rates?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: RatesAdapter.ViewHolder, position: Int) {
        holder.handleData(rates?.get(position))
        holder.itemView.setOnClickListener {
            rates?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }

}