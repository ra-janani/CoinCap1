

    package com.example.coincap1.ui.exchanges

    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.core.content.ContextCompat
    import androidx.recyclerview.widget.RecyclerView
    import com.example.coincap1.R
    import com.example.coincap1.data.exchanges.DataModel
    import com.example.coincap1.data.exchanges.ExchangesModel
    import com.example.coincap1.databinding.ItemExchangesBinding

    class ExchangesAdapter(val exchanges: List<DataModel>?) :
        RecyclerView.Adapter<ExchangesAdapter.ViewHolder>() {

        var onItemClick: ((DataModel) -> Unit)? = null
        // ITEM/ROW all the settings/UI of individual items
        class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            private val binding = ItemExchangesBinding.bind(view)

            fun handleData(item: DataModel?) {
                binding.textView2.text = item?.rank
                binding.textView3.text = item?.name
                binding.textView4.text =item?.tradingPairs


                if (adapterPosition % 2 == 0) {
                    binding.llExchanges.setBackgroundColor(
                        ContextCompat.getColor(
                            view.context,
                            R.color.purple_200
                        )
                    )
                } else {
                    binding.llExchanges.setBackgroundColor(
                        ContextCompat.getColor(
                            view.context,
                            R.color.purple_700
                        )
                    )
                }
            }

        }

        // Creates the ITEM/ROW for the UI
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangesAdapter.ViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exchanges, parent, false)

            return ViewHolder(view)
        }

        // Size of the list
        override fun getItemCount(): Int = exchanges?.size ?: 0

        // Handle the CURRENT item you are on
        override fun onBindViewHolder(holder: ExchangesAdapter.ViewHolder, position: Int) {
            holder.handleData(exchanges?.get(position))
            holder.itemView.setOnClickListener {
                exchanges?.get(position)?.let {
                    onItemClick?.invoke(it)
                }
            }
        }

    }

