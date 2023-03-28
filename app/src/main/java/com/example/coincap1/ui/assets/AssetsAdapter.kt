package com.example.coincap1.ui.assets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coincap1.R
import com.example.coincap1.data.assets.AssetsModel
import com.example.coincap1.data.assets.DataModel
import com.example.coincap1.databinding.ItemAssetsBinding

class AssetsAdapter(val assets: List<DataModel?>) :
    RecyclerView.Adapter<com.example.coincap1.ui.assets.AssetsAdapter.ViewHolder>() {

    // ITEM/ROW all the settings/UI of individual items
    var onItemClick:((DataModel)->Unit)?=null
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemAssetsBinding.bind(view)

        fun handleData(item: DataModel?) {
            binding.textView2.text = item?.name
            binding.textView3.text = item?.symbol
            binding.textView4.text =item?.rank


            if (adapterPosition % 2 == 0) {
                binding.llAssets.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.teal_700
                    )
                )

            } else {
                binding.llAssets.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.teal_200
                    )
                )


            }


        }

    }

    // Creates the ITEM/ROW for the UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): com.example.coincap1.ui.assets.AssetsAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_assets, parent, false)

        return ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = assets?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: com.example.coincap1.ui.assets.AssetsAdapter.ViewHolder, position: Int) {
        holder.handleData(assets?.get(position))
        holder.itemView.setOnClickListener{assets?.get(position)?.let{

            onItemClick?.invoke(it)
        }
        }

    }

}


